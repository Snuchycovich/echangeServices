package webapp;

import java.io.IOException;

import java.util.Date;
import java.util.Locale;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
			res.sendRedirect("logIn");
			return;
		}
		req.setAttribute( "person", person );
		req.getRequestDispatcher("/pages/addService.jsp").forward(req, res);
	}
	
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String typedb = req.getParameter("type");
		
		boolean type = Boolean.valueOf(typedb);
		
		String limitDateString = req.getParameter("limitDate");
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.FRANCE);
		Date limitDate = null;
		try {
			limitDate = df.parse(limitDateString);
		} catch (ParseException e1) {
			res.sendRedirect("http://www.google.fr");
			e1.printStackTrace();
		}
		
		// Create service
		Service service = new Service(title);
		int idService = service.getId();
		
		HttpSession session = req.getSession();
		Person person = (Person) session.getAttribute("person");
		String emailPerson = person.getEmail();
		
		PersonServiceAssociation servicePersonAssociation = new PersonServiceAssociation(emailPerson, idService, description, limitDate, type);
		
		
		try {
			// Insert service into DB
			 new DBHandler().SQLServiceDB.create(service);
			 new DBHandler().SQLPersonServiceDB.create(servicePersonAssociation);
        } catch (Exception e) {
            this.terminate(req,res,"Erreur d'insertion dans la base ("+e+").");
            e.printStackTrace();
            return;
        }
        // Everything went well
        this.terminate(req,res,"Nous avons bien pris en compte le nouveau service, merci.");
	}
	
	/**
     * Terminates the response of this servlet by displaying table of contents and a message.
     * @param request The request for this call
     * @param response The response for this call
     * @param message The message to be forwarded to table of contents
     */
    protected void terminate(HttpServletRequest req, HttpServletResponse res, String message) throws ServletException, IOException {
        res.sendRedirect(res.encodeRedirectURL(req.getContextPath()+"/index.jsp?message="+message));
    }
    
    @Override
    public void destroy () {
        try {
        	DBHandler.close();
        } catch (SQLException e) {
            this.log("Erreur lors de la cl&ocirc;ture de la connexion SQL ("+e+").");
       }
    }
}
