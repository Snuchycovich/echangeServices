package webapp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.enterprise.web.PEWebContainerStartStopOperation;

import persons.Person;
import services.Service;

public class AdminServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
		HttpSession session = req.getSession();
		Person admin = (Person) session.getAttribute( "person" );
		if (admin == null) {
			if(admin.getRole() == 1){
				resp.sendRedirect("mon-espace");
				return;
			}
			resp.sendRedirect("logIn");
			return;
		}
		
		List<Person> persons = null;
		
		try {
			persons = (List<Person>) new DBHandler().SQLPersonDB.retrieveAll();
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Service> services = null;
		try {
			services = (List<Service>) new DBHandler().SQLServiceDB.retrieveAll();
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<PersonServiceAssociation> psa = null;
		try {
			psa = (List<PersonServiceAssociation>) new DBHandler().SQLPersonServiceDB.retrieveAll();
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("psa", psa);
		req.setAttribute("services", services);
		req.setAttribute("persons", persons);
		req.getRequestDispatcher("/pages/admin.jsp").forward(req, resp);
	}

}
