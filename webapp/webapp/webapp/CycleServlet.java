package webapp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persons.Person;
import services.Service;

public class CycleServlet extends HttpServlet{
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		// If the user is not connected, he is redirected to the login page
		Person person = (Person) session.getAttribute( "person" );
		if (person == null) {
			res.sendRedirect(req.getContextPath()+"/logIn");
			return;
		}
		
		Service service = null;
		List<PersonServiceAssociation> listPsa = null;
		try {
			// We retrieve the content of id parameter in URL
			int id = Integer.parseInt(req.getParameter("id"));
			
			// We retrieve the service associated we the previous id retrieved
			service = new DBHandler().SQLServiceDB.retrieve(id);
			
			// We retrieve every persons
			Collection<Person> persons = new DBHandler().SQLPersonDB.retrieveAll();
			
			Hashtable<Person, List> listServicesDemandes = new Hashtable<Person,List>();
			Hashtable<Person, List> listServicesOfferts = new Hashtable<Person,List>();
			
			// We retrieve every services of a person
			for (Person personUnique : persons) {
				List<PersonServiceAssociation> ListPsa = new DBHandler().SQLPersonServiceDB.retrieveAllByPerson(personUnique);
				List<Service> servicesDemandes = new ArrayList<Service>();
				List<Service> servicesOfferts = new ArrayList<Service>();
				for (PersonServiceAssociation psa : ListPsa) {
					Service serviceUnique = new DBHandler().SQLServiceDB.retrieve(psa.getIdService());
					if(psa.getStatus() == 0)
						servicesDemandes.add(serviceUnique);
					else
						servicesOfferts.add(serviceUnique);
				}
				
				listServicesDemandes.put(personUnique, servicesDemandes);
				listServicesOfferts.put(personUnique, servicesOfferts);
			}
			
			
			// We launch the algorithm
			Algo algo = new Algo();
			String cycle = "";
			cycle = algo.runAlgoServiceDemande(person, service, listServicesDemandes, listServicesOfferts);
			
			req.setAttribute("listServicesDemandes", listServicesDemandes);
			req.setAttribute("listServicesOfferts", listServicesOfferts);
			req.setAttribute("cycle", cycle);
			req.getRequestDispatcher("/pages/cycle.jsp").forward(req, res);
			
			
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
	

}
