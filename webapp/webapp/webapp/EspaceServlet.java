package webapp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persons.Person;
import services.Service;

public class EspaceServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Person person = (Person) session.getAttribute( "person" );
		List<PersonServiceAssociation> servicesPerson = null;
		
		
		try {
			servicesPerson = new DBHandler().SQLPersonServiceDB.retrieveAllByPerson(person);
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Service> servicesDemandes = new ArrayList<Service>();
		List<Service> servicesOffres = new ArrayList<Service>();
		
		for (PersonServiceAssociation psa : servicesPerson) {
			Service s = null;
			try {
				s = new DBHandler().SQLServiceDB.retrieve(psa.getIdService());
			} catch (SQLException | NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if( psa.getStatus() == 0 )
				servicesDemandes.add(s);
			else
				servicesOffres.add(s);
		}
	
		req.setAttribute("listeServicesDemandes", servicesDemandes);
		req.setAttribute("listeServicesOffres", servicesOffres);
		req.getRequestDispatcher("/pages/mon-espace.jsp").forward(req, resp);
		
	}
}