package webapp;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persons.Person;

import services.Service;

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
		query = "SELECT * FROM `"+ this.table + "` WHERE idPerson=? AND idService=?";
		this.retrievePersonServiceStatement = this.link.prepareStatement(query);
		query = "SELECT * FROM `"+ this.table + "` WHERE idPerson=?";
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
        query+="idPerson int(11), ";
        query+="idService int(11), ";
        query+="description TEXT, ";
        query+="creationDate DATETIME, ";
        query+="limitDate DATETIME, ";
        query+="status int(11)";
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
    
    public void create(PersonServiceAssociation psa) throws SQLException {
        this.createPersonServiceStatement.setInt(1,psa.getIdPerson());
        this.createPersonServiceStatement.setInt(2,psa.getIdService());
        this.createPersonServiceStatement.setString(3,psa.getDescription());
        
        java.sql.Timestamp creationDateSQL = new java.sql.Timestamp(psa.getCreationDate().getTime());
        this.createPersonServiceStatement.setTimestamp(4,creationDateSQL);
        
        java.sql.Timestamp limitDateSQL = new java.sql.Timestamp(psa.getLimitDate().getTime());
        this.createPersonServiceStatement.setTimestamp(5,limitDateSQL);
        
        this.createPersonServiceStatement.setInt(6,psa.getStatus());
        
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
            res.add(new PersonServiceAssociation(rs.getInt("idPerson"), rs.getInt("idService"), rs.getString("description"), rs.getDate("creationDate"), rs.getDate("limitDate"), rs.getInt("status")));
        }
        return res;
    }

    /**
     * Retrieves a service in the database.
     * @param id The id of the service
     * @return A service, or null if none with the given id exists in the database
     * @throws SQLException if a database access error occurs
     */
    public PersonServiceAssociation retrieve (int idPerson, int idService) throws SQLException {
        this.retrievePersonServiceStatement.setInt(1,idPerson);
        this.retrievePersonServiceStatement.setInt(2,idService);
        ResultSet rs=this.retrievePersonServiceStatement.executeQuery();
        if (!rs.next()) {
            return null;
        }
        return new PersonServiceAssociation(rs.getInt("idPerson"), rs.getInt("idService"), rs.getString("description"), rs.getDate("creationDate"), rs.getDate("limitDate"), rs.getInt("status"));
    }
    
    public List<PersonServiceAssociation> retrieveAllByPerson (Person person) throws SQLException {
        this.retrieveServiceByPersonStatement.setInt(1, person.getId());
        ResultSet rs=this.retrieveServiceByPersonStatement.executeQuery();
        List<PersonServiceAssociation> res=new ArrayList<PersonServiceAssociation>();
        while (rs.next()) {
            res.add(new PersonServiceAssociation(rs.getInt("idPerson"), rs.getInt("idService"), rs.getString("description"), rs.getDate("creationDate"), rs.getDate("limitDate"), rs.getInt("status")));
        }
        return res;
    }
    
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
     * Deletes a person - service association. Nothing occurs in case the service does not exist in the database.
     * @param idPerson The person's id
     * @param idService The service' id
     * @throws SQLException if a database access error occurs
     */
    
    public void deletePersonService (int idPerson, int idService) throws SQLException {  
        String query="DELETE FROM `"+this.table+"` WHERE idPerson="+idPerson+" AND idService="+idService;
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }
    
    /**
     * Deletes a Association Person - Service association. Nothing occurs in case the service does not exist in the database.
     * @param int id of the Person that has added the the service.
     * @throws SQLException if a database access error occurs
     */
    
    public void deletePersonService (int idPerson) throws SQLException {  
        String query="DELETE FROM `"+this.table+"` WHERE idPerson="+idPerson+"";
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }
}
