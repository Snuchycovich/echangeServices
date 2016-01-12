package webapp;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLPersonServiceDB {
	
	/** The name for the SQL table where to store products. */
	protected String table;
	
	/** A prepared statement for creations. */
	private PreparedStatement createPersonServiceStatement;
	
	/** A prepared statement for retrieval of one product. */
	private PreparedStatement retrievePersonServiceStatement;
	
	/** A prepared statement for retrieval of one product. */
	private PreparedStatement retrieveServiceByPersonStatement;
	
	/** A link to the database. */
	protected Connection link; 
	
	/**
	 * Builds a new instance.
	 * @param link An active connection to an SQL database
	 * @param table The name of the table where to store services
	 * @throws SQLException if a database access error occurs
	 */
	public SQLPersonServiceDB(Connection link, String table) throws SQLException {
		this.table = table;
		this.link = link;
		String query = null;
		query = "INSERT INTO `" + this.table + "` VALUES(?,?,?,?,?,?)";
		this.createPersonServiceStatement = this.link.prepareStatement(query);
		query = "SELECT * FROM `"+ this.table + "` WHERE email_Person=? AND id_Service=?";
		this.retrievePersonServiceStatement = this.link.prepareStatement(query);
		query = "SELECT * FROM `"+ this.table + "` WHERE email_Person=?";
		this.retrieveServiceByPersonStatement = this.link.prepareStatement(query);
	}
	
	// Methods

    /**
     * Resets the link to the database.
     * This method can be used in case the connection breaks down.
     * @param link An active link to the database
     */
    public void setLink (Connection link) {
        this.link=link;
    }
    
    /**
     * Creates the necessary table in the database. Nothing occurs if the table already exists.
     * @throws SQLException if a database access error occurs
     */
    public void createTables () throws SQLException {
        String query="CREATE TABLE IF NOT EXISTS `"+this.table+"` (";
        query+="id INT NOT NULL AUTO_INCREMENT, ";
        query+="email_Person VARCHAR(100) NOT NULL, ";
        query+="id_Service int(11) NOT NULL, ";
        query+="description text() NOT NULL, ";
        query+="creationDate DATETIME, ";
        query+="limitDate DATETIME, ";
        query+="type int(1) NOT NULL, ";
        query+="PRIMARY KEY (id) ";
        query+=")";
        // System.out.println(query);
        Statement statement=this.link.createStatement();
        statement.execute(query);
        
    }
    
	/**
     * Stores a new service in the database.
     * @param service The service to store
     * @throws SQLException if a database access error occurs
     */
    
    public void create(PersonServiceAssociation spa) throws SQLException {
    	this.createPersonServiceStatement.setObject(1,null);
        this.createPersonServiceStatement.setString(2,spa.getEmailPerson());
        this.createPersonServiceStatement.setInt(3,spa.getId_service());
        this.createPersonServiceStatement.setString(4,spa.getDescription());
      
        
        java.sql.Timestamp myDateCreationSQL = new java.sql.Timestamp(spa.getCreationDate().getTime());
        this.createPersonServiceStatement.setTimestamp(5, myDateCreationSQL);
        
        java.sql.Timestamp myDateLimitSQL = new java.sql.Timestamp(spa.getLimitDate().getTime());
        this.createPersonServiceStatement.setTimestamp(6, myDateLimitSQL);
        
        this.createPersonServiceStatement.setBoolean(7, spa.isType());
        
        this.createPersonServiceStatement.execute();
    }

    /**
     * Retrieves all the associations in the database.
     * @return A list of all Associations in the database
     * @throws SQLException if a database access error occurs
     */
    public List<PersonServiceAssociation> retrieveAll () throws SQLException {
        String query="SELECT * FROM `"+this.table+"`";
        ResultSet rs=null;
        Statement statement=this.link.createStatement();
        rs=statement.executeQuery(query);
        List<PersonServiceAssociation> res=new ArrayList<PersonServiceAssociation>();
      
        while (rs.next()) {
     
            res.add(new PersonServiceAssociation(rs.getString("email"), rs.getInt("id_Service"), rs.getString("description"), rs.getDate("limitDate"), rs.getBoolean("type")));
        }
        return res;
    }

    /**
     * Retrieves a service in the database.
     * @param id The id of the service
     * @return A service, or null if none with the given id exists in the database
     * @throws SQLException if a database access error occurs
     */
    public PersonServiceAssociation retrieve (int id) throws SQLException {
        this.retrievePersonServiceStatement.setInt(1,id);
        ResultSet rs=this.retrievePersonServiceStatement.executeQuery();
        if (!rs.next()) {
            return null;
        }
        return new PersonServiceAssociation(rs.getString("email"), rs.getInt("id_Service"), rs.getString("description"), rs.getDate("limitDate"), rs.getBoolean("type"));
    }
    
    public PersonServiceAssociation retrieveByPersone (String email) throws SQLException {
        this.retrieveServiceByPersonStatement.setString(1, email);
        ResultSet rs=this.retrievePersonServiceStatement.executeQuery();
        if (!rs.next()) {
            return null;
        }
        return new PersonServiceAssociation(rs.getString("email"), rs.getInt("id_Service"), rs.getString("description"), rs.getDate("limitDate"), rs.getBoolean("type"));
    }
    
    /**
     * 
     */
    
	/*public void update(Service s) throws Exception {
		this.updateServiceStatement.setString(1, s.getTitle());
		this.updateServiceStatement.setString(2, s.getDescription());
		this.updateServiceStatement.setString(3, s.getTitle());
		this.updateServiceStatement.setString(4, s.getCategory());
		this.updateServiceStatement.setLong(5, s.getId());
		this.updateServiceStatement.execute();
	}*/
	
	/**
     * Drops the table from the database. Nothing occurs if the table does not exist.
     * @throws SQLException if a database access error occurs
     */
    public void deleteTables() throws SQLException {
        String query="DROP TABLE IF EXISTS `"+this.table+"`";
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }

    /**
     * Deletes a service. Nothing occurs in case the service does not exist in the database.
     * @param service The service
     * @throws SQLException if a database access error occurs
     */
    
    public void deleteByEmail (PersonServiceAssociation spa) throws SQLException {  
        String query="DELETE FROM `"+this.table+"` WHERE email=\""+spa.getEmailPerson()+"\"";
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }
    
    public void deleteOneService (PersonServiceAssociation spa) throws SQLException {  
        String query="DELETE FROM `"+this.table+"` WHERE email=\""+spa.getEmailPerson()+"\" AND id_Service=\""+spa.getId_service()+"\"";
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }
}
