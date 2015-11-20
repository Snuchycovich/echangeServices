package webapp;


import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.SQLServiceDB;

public class ServicesDBHandler {

	/** The unique link to the database (null if none active). */
    private static Connection link;

    /** The unique instance of class SQLServicesDB (null if none). */
    private static SQLServiceDB db;
    
    /**
     * Builds a new instance, using the strings used in the environment.
     * @throws NamingException if strings host, database, username, password, or table cannot be found
     * @throws SQLException if any problem occurs for accessing the database
     */
    public ServicesDBHandler () throws NamingException, SQLException {
        if (ServicesDBHandler.db==null) {
            ServicesDBHandler.initialize();
        }
    }
    
    /**
     * Returns the instance of SQLServiceDB.
     * @throws NamingException if strings host, database, username, password, or table cannot be found
     * @throws SQLException if any problem occurs for accessing the database
     */
    public SQLServiceDB getDb () throws NamingException, SQLException {
        if (ServicesDBHandler.db==null) {
            ServicesDBHandler.initialize();
        }
        return ServicesDBHandler.db;
    }
    
    /**
     * Releases the connection to the database.
     * @throws SQLException if any problem occurs while closing the connection
     */
    public static void close () throws SQLException {
        if (ServicesDBHandler.link!=null) {
        	ServicesDBHandler.link.close();
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
        String table=initialContext.doLookup("java:comp/env/table");
        ServicesDBHandler.db = new SQLServiceDB(ServicesDBHandler.getLink(host,database,username,password),table);
        ServicesDBHandler.db.createTables();
    }
    
    /**
     * Returns the link to the database, which is active.
     * @param host The hostname for the DBMS
     * @paam database The name for the database to use in the DBMS
     * @param username The username for connecting to the database
     * @param password The password for connecting to the database
     * @return An active link to the database
     * @throws SQLException if no active link can be established
     */
    private static Connection getLink (String host, String database, String username, String password) throws SQLException {
        if (ServicesDBHandler.link==null) {
            MysqlDataSource ds=new MysqlDataSource();
            ds.setServerName(host);
            ds.setDatabaseName(database);
            ServicesDBHandler.link=ds.getConnection(username,password);
        }
        if (!ServicesDBHandler.link.isValid(0)) {
            throw new SQLException("Failed to initialize a valid connection to database.");
        }
        return ServicesDBHandler.link;
    }
}
