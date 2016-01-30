package webapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLPSCompleteInfoDB {
	/** A link to the database. */
	protected Connection link;
	
	/**
	 * Connection to the database.
	 * @param link An active connection to an SQL database
	 * @throws SQLException if a database access error occurs
	 */
	public SQLPSCompleteInfoDB(Connection link) throws SQLException {
		this.link = link;
	}
	 /**
     * Retrieves all PersonService associations in the database.
     * @return A PersonService association, or null if none with the given id exists in the database
     * @throws SQLException if a database access error occurs
     */
	public List<PSCompleteInfo> retrieveAll() throws SQLException {
		String query ="SELECT ps.idPerson, ps.idService, ps.description, ps.creationDate, ps.limitDate, ps.status, s.id, s.title, p.name, p.firstName, p.email, p.inscriptionDate "
				+ "FROM personService ps INNER JOIN services s ON ps.idService = s.id INNER JOIN persons p ON ps.idPerson = p.id";
		ResultSet rs=null;
        Statement statement=this.link.createStatement();
        rs=statement.executeQuery(query);
        List<PSCompleteInfo> res=new ArrayList<PSCompleteInfo>();
		
        while (rs.next()) {
            res.add(new PSCompleteInfo(rs.getInt("idPerson"), rs.getInt("idService"), rs.getString("description"), rs.getDate("creationDate"), rs.getDate("limitDate"), rs.getInt("status"), rs.getString("title"), rs.getString("name"), rs.getString("firstName"), rs.getString("email"), rs.getDate("inscriptionDate")));
        }
        return res;
	}
	 /**
     * Retrieves a list of PersonService association by Person in the database.
     * @param idPerson The person's id
     * @return A PersonService association, or null if none with the given id exists in the database
     * @throws SQLException if a database access error occurs
     */
	public List<PSCompleteInfo> retrieveByPerson(int idPerson) throws SQLException {
		String query ="SELECT ps.description, ps.creationDate, ps.limitDate, ps.status, s.id, s.title, p.name, p.firstName, p.email, p.inscriptionDate "
				+ "FROM personService ps INNER JOIN services s ON ps.idService = s.id INNER JOIN persons p ON ps.idPerson = p.id WHERE  ps.idPerson ="+idPerson+"";
		ResultSet rs=null;
        Statement statement=this.link.createStatement();
        rs=statement.executeQuery(query);
        List<PSCompleteInfo> res=new ArrayList<PSCompleteInfo>();
		
        while (rs.next()) {
            res.add(new PSCompleteInfo(rs.getInt("idPerson"),rs.getInt("idService"), rs.getString("description"), rs.getDate("creationDate"), rs.getDate("limitDate"), rs.getInt("status"), rs.getString("title"), rs.getString("name"), rs.getString("firstName"), rs.getString("email"), rs.getDate("inscriptionDate")));
        }
        return res;
	}

}
