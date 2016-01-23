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
		if(person == null) {
			resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath()+"/home"));
			return;
		}
		
		List<PSCompleteInfo> psCompleteInfo = null;
		try {
			psCompleteInfo = new DBHandler().SQLPSCompleteInfoDB.retrieveAll();
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<PSCompleteInfo> servicesDemandes = new ArrayList<PSCompleteInfo>();
		List<PSCompleteInfo> servicesOffres = new ArrayList<PSCompleteInfo>();
		
		for (PSCompleteInfo psCInfo : psCompleteInfo) {
			
			if( psCInfo.getStatus() == 0 )
				servicesDemandes.add(psCInfo);
			else
				servicesOffres.add(psCInfo);
		}
	
		req.setAttribute("listeServicesDemandes", servicesDemandes);
		req.setAttribute("listeServicesOffres", servicesOffres);
		req.getRequestDispatcher("/pages/mon-espace.jsp").forward(req, resp);
		
		/*List<PersonServiceAssociation> listPsa = null;
		try {
			listPsa = new DBHandler().SQLPersonServiceDB.retrieveAll();
			Algo algo = new Algo();
			algo.run(person, service, psa);
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}*/
		
	}
}