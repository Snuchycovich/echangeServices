package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persons.Person;

public class LogInServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        req.getRequestDispatcher("/pages/logIn.jsp").forward(req, resp);
        
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    	String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        try {
			// Insert service into DB
			 if( new DBHandler().SQLPersonDB.isValid(email, password) ) {
				 
				 Person person = new DBHandler().SQLPersonDB.retrieve(email);
				 
				 HttpSession session = req.getSession();
				 session.setAttribute("person", person);
				 
				 resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath()+"/index.jsp?message=Connexion OK"));
				 
			 } else {
				 resp.sendRedirect("http://www.unicaen.fr");
			 }
        } catch (Exception e) {
            
        	this.terminate(req,resp,"Erreur d'insertion dans la base ("+e+").");
            e.printStackTrace();
            
            return;
            
        }
            
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
}