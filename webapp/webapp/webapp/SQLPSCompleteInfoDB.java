package webapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLPSCompleteInfoDB {
	
	protected Connection link;
	
	public SQLPSCompleteInfoDB(Connection link) throws SQLException {
		this.link = link;
	}
	
	public List<PSCompleteInfo> retrieveAll() throws SQLException {
		String query ="SELECT ps.description, ps.creationDate, ps.limitDate, ps.status, s.id, s.title, p.name, p.firstName, p.email, p.inscriptionDate "
				+ "FROM personService ps INNER JOIN services s ON ps.idService = s.id INNER JOIN persons p ON ps.idPerson = p.id";
		ResultSet rs=null;
        Statement statement=this.link.createStatement();
        rs=statement.executeQuery(query);
        List<PSCompleteInfo> res=new ArrayList<PSCompleteInfo>();
		
        while (rs.next()) {
            res.add(new PSCompleteInfo(rs.getInt("id"), rs.getString("description"), rs.getDate("creationDate"), rs.getDate("limitDate"), rs.getInt("status"), rs.getString("title"), rs.getString("name"), rs.getString("firstName"), rs.getString("email"), rs.getDate("inscriptionDate")));
        }
        return res;
	}

}
