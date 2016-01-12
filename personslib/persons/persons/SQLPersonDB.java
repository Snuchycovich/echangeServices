package persons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public class SQLPersonDB implements IPersonDB{
	
	/** The name for the SQL table where to store products. */
	protected String table;
	
	/** A prepared statement for creations. */
	private PreparedStatement createStatement;
	
	/** A prepared statement for retrieval of one product. */
	private PreparedStatement retrieveStatement;
	
	/** A prepared statement for retrieval of one product. */
	private PreparedStatement updateStatement;
	
	/** A link to the database. */
	protected Connection link; 
	
	/**
	 * Builds a new instance.
	 * @param link An active connection to an SQL database
	 * @param table The name of the table where to store services
	 * @throws SQLException if a database access error occurs
	 */
	public SQLPersonDB(Connection link, String table) throws SQLException {
		this.table = table;
		this.link = link;
		String query = null;
		query = "INSERT INTO `" + this.table + "` VALUES(?,?,?,?,MD5(?),?)";
		this.createStatement = this.link.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		query = "SELECT * FROM `"+ this.table + "` WHERE email=?";
		this.retrieveStatement = this.link.prepareStatement(query);
		query = "UPDATE `" + this.table + "` SET name=?, firstName=?, email=? WHERE id=?";
		this.updateStatement =this.link.prepareStatement(query);
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
        query+="name VARCHAR(100) NOT NULL, ";
        query+="firstName VARCHAR(100) NOT NULL, ";
        query+="email VARCHAR(100) NOT NULL, ";
        query+="password TEXT NOT NULL, ";
        query+="inscriptionDate DATETIME, ";
        query+="PRIMARY KEY (id) ";
        query+=")";
        // System.out.println(query);
        Statement statement=this.link.createStatement();
        statement.execute(query);
        
    }
    
	/**
     * Stores a new service in the database.
     * @param service The service to store
     * @return the id of the created person
     * @throws SQLException if a database access error occurs
     */
    @Override
    public int create(Person person, String password) throws SQLException {
    	this.createStatement.setObject(1,null);
        this.createStatement.setString(2,person.getName());
        this.createStatement.setString(3,person.getFirstName());
        this.createStatement.setString(4,person.getEmail());
        this.createStatement.setString(5,password);
        
        java.sql.Timestamp subscriptionDateSQL = new java.sql.Timestamp(person.getSubscriptionDate().getTime());
        this.createStatement.setTimestamp(6, subscriptionDateSQL);
        
        return this.createStatement.executeUpdate();
    }

    /**
     * Retrieves all the products in the database.
     * @return A list of all products in the database
     * @throws SQLException if a database access error occurs
     */
    @Override
    public Collection<Person> retrieveAll() throws SQLException {
        String query="SELECT * FROM `"+this.table+"`";
        ResultSet rs=null;
        Statement statement=this.link.createStatement();
        rs=statement.executeQuery(query);
        
        List<Person> persons=new ArrayList<Person>();
        
        while (rs.next()) {
        	persons.add(new Person(rs.getInt("id"), rs.getString("name"),rs.getString("firstName"),rs.getString("email")));
        }
       
        return persons;
    }

    
    
    /**
     * 
     */
    @Override
	public void update(Person p) throws Exception {
		this.updateStatement.setString(1, p.getName());
		this.updateStatement.setString(2, p.getFirstName());
		this.updateStatement.setString(3, p.getEmail());
		this.updateStatement.setInt(4, p.getId());
		this.updateStatement.execute();
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
     * Deletes a service. Nothing occurs in case the service does not exist in the database.
     * @param service The service
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void delete (int id) throws SQLException {  
        String query="DELETE FROM `"+this.table+"` WHERE id=\""+id+"\"";
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }

	/**
     * Retrieves a service in the database.
     * @param id The id of the service
     * @return A service, or null if none with the given id exists in the database
     * @throws SQLException if a database access error occurs
     */
	@Override
	public Person retrieve (String email) throws Exception {
        this.retrieveStatement.setString(1,email);
        ResultSet rs=this.retrieveStatement.executeQuery();
        if (!rs.next()) {
            return null;
        }
        return new Person(rs.getInt("id"), rs.getString("name"),rs.getString("firstName"),rs.getString("email"));
    }

	@Override
	public boolean isValid(String email, String password) throws Exception {
		String query = "SELECT id FROM `"+ this.table + "` WHERE email=? AND password=MD5(?)";
		PreparedStatement statement = this.link.prepareStatement(query);
		statement.setString(1,email);
		statement.setString(2,password);
		ResultSet rs = statement.executeQuery();
        if (!rs.next()) {
        	return false;
        } else {
        	return true;
        }
	}

	@Override
	public boolean exists(String email) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updatePassword(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
