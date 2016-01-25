package webapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persons.Person;
import services.Service;

public class AddServiceServlet extends HttpServlet{
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Person person = (Person) session.getAttribute( "person" );
		if (person == null) {
			res.sendRedirect(req.getContextPath()+"/logIn");
			return;
		}
		List<Service> servicesList = new ArrayList<Service>();
		try {
			servicesList = new DBHandler().SQLServiceDB.retrieveAll();
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
		req.setAttribute("servicesList", servicesList);
		req.setAttribute( "person", person );
		req.getRequestDispatcher("/pages/addService.jsp").forward(req, res);
	}
	
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String description = req.getParameter("description");
		int status = Integer.parseInt(req.getParameter("status"));
		String limitDateString = req.getParameter("limitDate");
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.FRANCE);
		Date limitDate = null;
		
		try {
			limitDate = df.parse(limitDateString);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		// Create service
		String serviceTitle = "";
		Service service = null;
		int nbService = Integer.parseInt(req.getParameter("title"));
		if(nbService == 0) {
			serviceTitle = req.getParameter("addServiceTitle");
			service = new Service(serviceTitle);
			try {
				// Insert service into DB
				 int idService = new DBHandler().SQLServiceDB.create(service);
				 service.setId(idService);
			} catch (Exception e) {
	            this.error(req,res);
	            e.printStackTrace();
	            return;
	        }
		}else {
			int serviceId = Integer.parseInt(req.getParameter("title"));
			try {
				service = new DBHandler().SQLServiceDB.retrieve(serviceId);
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
			}
		}
		
		
		HttpSession session = req.getSession();
		Person person = (Person) session.getAttribute("person");
		
		PersonServiceAssociation servicePersonAssociation = new PersonServiceAssociation(person.getId(), service.getId(), description, limitDate, status);
		
		// Insert servicePersonAssociation into DB
		try {
			 new DBHandler().SQLPersonServiceDB.create(servicePersonAssociation);
        } catch (Exception e) {
            this.error(req,res);
            e.printStackTrace();
            return;
        }
		
        // Everything went well
        this.success(req,res);
	}
	
	/**
     * Terminates the response of this servlet by redirecting the user to a success page.
     * @param request The request for this call
     * @param response The response for this call
     */
    protected void success(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.sendRedirect(res.encodeRedirectURL(req.getContextPath()+"/service/add/complete"));
    }
    
    /**
     * Terminates the response of this servlet by redirecting the user to an error page.
     * @param request The request for this call
     * @param response The response for this call
     */
    protected void error(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.sendRedirect(res.encodeRedirectURL(req.getContextPath()+"/service/add/error"));
    }
}
