package webapp;


import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.SQLServiceDB;
import persons.SQLPersonDB;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;



public class DBHandler {

	/** The unique link to the database (null if none active). */
    private static Connection link;

    /** The unique instance of class SQLServicesDB (null if none). */
    public static SQLServiceDB SQLServiceDB;
    
    /** The unique instance of class SQLPersonDB (null if none). */
    public static SQLPersonDB SQLPersonDB;
    
    /** The unique instance of class SQLServicePersonDB (null if none). */
    public static SQLPersonServiceDB SQLPersonServiceDB;
    
    public static SQLPSCompleteInfoDB SQLPSCompleteInfoDB;
    
    /**
     * Builds a new instance, using the strings used in the environment.
     * @throws NamingException if strings host, database, username, password, or table cannot be found
     * @throws SQLException if any problem occurs for accessing the database
     */
    public DBHandler () throws NamingException, SQLException {
        if (DBHandler.SQLServiceDB==null || DBHandler.SQLPersonDB==null || DBHandler.SQLPersonServiceDB==null || DBHandler.SQLPSCompleteInfoDB==null) {
        	DBHandler.initialize();
        }
    }
    
    /**
     * Releases the connection to the database.
     * @throws SQLException if any problem occurs while closing the connection
     */
    public static void close() throws SQLException {
        if (DBHandler.link!=null) {
        	DBHandler.link.close();
        }
    }
    
 // Helper methods =====================================================================

    /**
     * Initializes the connection to the database and the instance of SQLProductsDB.
     * For each of these objects, nothing occurs if it is already initialized.
     * @throws NamingException if strings host, database, username, password, or table cannot be found
     * @throws SQLException if any problem occurs for accessing the database
     */
    private static void initialize () throws NamingException, SQLException {
        InitialContext initialContext = new InitialContext();
        String host=initialContext.doLookup("java:comp/env/host");
        String database=initialContext.doLookup("java:comp/env/database");
        String username=initialContext.doLookup("java:comp/env/username");
        String password=initialContext.doLookup("java:comp/env/password");
        //String password="";
        
        SQLServiceDB = new SQLServiceDB(DBHandler.getLink(host,database,username,password), "services");
        SQLServiceDB.createTables();
        
        SQLPersonDB = new SQLPersonDB(DBHandler.getLink(host,database,username,password), "persons");
        SQLPersonDB.createTables();
        
        SQLPersonServiceDB = new SQLPersonServiceDB(DBHandler.getLink(host,database,username,password), "personService");
        SQLPersonServiceDB.createTables();
        
        SQLPSCompleteInfoDB = new SQLPSCompleteInfoDB(DBHandler.getLink(host,database,username,password));
    }
    
    /**
     * Returns the link to the database, which is active.
     * @param host The hostname for the DBMS
     * @param database The name for the database to use in the DBMS
     * @param username The username for connecting to the database
     * @param password The password for connecting to the database
     * @return An active link to the database
     * @throws SQLException if no active link can be established
     */
    private static Connection getLink (String host, String database, String username, String password) throws SQLException {
        if (DBHandler.link==null) {
            MysqlDataSource ds=new MysqlDataSource();
            ds.setServerName(host);
            ds.setDatabaseName(database);
            DBHandler.link=ds.getConnection(username,password);
        }
        if (!DBHandler.link.isValid(0)) {
            throw new SQLException("Failed to initialize a valid connection to database.");
        }
        return DBHandler.link;
    }
}
