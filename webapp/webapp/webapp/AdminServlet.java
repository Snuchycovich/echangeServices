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
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	        throws ServletException, IOException {
		HttpSession session = req.getSession();
		Person person = (Person) session.getAttribute( "person" );
		if (person == null) {
			res.sendRedirect(req.getContextPath()+"/logIn");
			return;
		}
		if (person.getRole() == 1) {
			res.sendRedirect(req.getContextPath()+"/mon-espace");
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
		
		List<PSCompleteInfo> psCInf = null;
		try {
			psCInf = (List<PSCompleteInfo>) new DBHandler().SQLPSCompleteInfoDB.retrieveAll();
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("role", person.getRole());
		req.setAttribute("psa", psCInf);
		req.setAttribute("services", services);
		req.setAttribute("persons", persons);
		req.getRequestDispatcher("/pages/admin.jsp").forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String idPerson = "";
		idPerson = req.getParameter("idPerson");
		if (idPerson != null) {
		int idp = Integer.parseInt(idPerson);
			try {
				new DBHandler().SQLPersonDB.delete(idp);
				new DBHandler().SQLPersonServiceDB.deletePersonService(idp);
			} catch (SQLException | NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String idService = "";
		idService = req.getParameter("idService");
		if (idService != null) {
			int ids = Integer.parseInt(idService);
			
			try {
				new DBHandler().SQLServiceDB.delete(ids);
			} catch (SQLException | NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		List<PSCompleteInfo> psCInf = null;
		try {
			psCInf = (List<PSCompleteInfo>) new DBHandler().SQLPSCompleteInfoDB.retrieveAll();
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("psa", psCInf);
		req.setAttribute("services", services);
		req.setAttribute("persons", persons);
		req.getRequestDispatcher("/pages/admin.jsp").forward(req, res);
	}

}
