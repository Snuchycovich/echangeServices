package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SQLServiceDB implements IServiceDB{
	
	/** The name for the SQL table where to store products. */
	protected String table;
	
	/** A prepared statement for creations. */
	private PreparedStatement createServiceStatement;
	
	/** A prepared statement for retrieval of one product. */
	private PreparedStatement retrieveServiceStatement;
	
	/** A link to the database. */
	protected Connection link; 
	
	/**
	 * Builds a new instance.
	 * @param link An active connection to an SQL database
	 * @param table The name of the table where to store services
	 * @throws SQLException if a database access error occurs
	 */
	public SQLServiceDB(Connection link, String table) throws SQLException {
		this.table = table;
		this.link = link;
		String query = null;
		query = "INSERT INTO `" + this.table + "` VALUES(?,?,?)";
		this.createServiceStatement = this.link.prepareStatement(query);
		query = "SELECT FROM `"+ this.table + "` WHERE name=?";
		this.retrieveServiceStatement = this.link.prepareStatement(query);	
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
        query+="`title` VARCHAR(100) NOT NULL, ";
        query+="`description` TEXT() NOT NULL, ";
        query+="`type` VARCHAR(100) NOT NULL, ";
        query+="`category` VARCHAR(100) NOT NULL, ";
        query+="PRIMARY KEY (`title`) ";
        query+=")";
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }
    
	/**
     * Stores a new service in the database.
     * @param service The service to store
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void create (Service service) throws SQLException {
        this.createServiceStatement.setString(1,service.getTitle());
        this.createServiceStatement.setString(2,service.getDescription());
        this.createServiceStatement.setString(3,service.getType());
        this.createServiceStatement.setString(4,service.getCategory());
        //this.createServiceStatement.setDate(5,service.getLimitDate());
        this.createServiceStatement.execute();
    }

    /**
     * Retrieves all the products in the database.
     * @return A list of all products in the database
     * @throws SQLException if a database access error occurs
     */
    @Override
    public List<Service> retrieveAll () throws SQLException {
        String query="SELECT * FROM `"+this.table+"`";
        ResultSet rs=null;
        Statement statement=this.link.createStatement();
        rs=statement.executeQuery(query);
        List<Service> res=new ArrayList<Service>();
        /*Date limitDate;
        GregorianCalendar limitGC;
        Date creationDate;
        GregorianCalendar creationGC;*/
        while (rs.next()) {
        	/*limitDate = rs.getDate("limitDate");
        	limitGC = new GregorianCalendar();
        	creationDate = rs.getDate("crationDate");
        	creationGC = new GregorianCalendar(creationDate.getTime());*/
            res.add(new Service(rs.getInt("id"), rs.getString("title"),rs.getString("description"),rs.getString("type"), rs.getString("category")));
        }
        return res;
    }

    /**
     * Retrieves a service in the database.
     * @param id The id of the service
     * @return A service, or null if none with the given id exists in the database
     * @throws SQLException if a database access error occurs
     */
    public Service retrieve (int id) throws SQLException {
        this.retrieveServiceStatement.setInt(1,id);
        ResultSet rs=this.retrieveServiceStatement.executeQuery();
        if (!rs.next()) {
            return null;
        }
        return new Service(rs.getInt("id"), rs.getString("title"),rs.getString("description"),rs.getString("type"), rs.getString("category"));
    }
    

	@Override
	public void update(String title, String Description, String type,
			String category, Date limitDate) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/**
     * Drops the table from the database. Nothing occurs if the table does not exist.
     * @throws SQLException if a database access error occurs
     */
    public void deleteTables () throws SQLException {
        String query="DROP TABLE IF EXISTS `"+this.table+"`";
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }

    /**
     * Deletes a service. Nothing occurs in case the service does not exist in the database.
     * @param service The service
     * @throws SQLException if a database access error occurs
     */
    public void delete (Service service) throws SQLException {  
        String query="DELETE FROM `"+this.table+"` WHERE name=\""+service.getId()+"\"";
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }


	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
