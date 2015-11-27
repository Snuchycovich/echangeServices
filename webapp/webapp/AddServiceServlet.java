package webapp;

import java.io.IOException;
import java.util.Date;
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

import services.Service;



public class AddServiceServlet extends HttpServlet{
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//String id = req.getParameter("id");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String type = req.getParameter("type");
		String category = req.getParameter("category");
		String getLimitDate = req.getParameter("limitDate");
		DateFormat df = new SimpleDateFormat(getLimitDate);
		Date limitDate = null;
		try {
			limitDate = df.parse(getLimitDate);
		} catch (ParseException e1) {
			res.sendRedirect("http://www.google.fr");
			e1.printStackTrace();
		}		
		// Insert service into DB
		Service service = new Service(title, description, type, category, limitDate);
		try {
			 new ServicesDBHandler().getDb().create(service);
			
			/*ResultSet rs = stmt.getGeneratedKeys();
	        if (rs.next()){
	        	resultat=rs.getInt(1);
	        }
	        rs.close();*/

           
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
            ServicesDBHandler.close();
        } catch (SQLException e) {
            this.log("Erreur lors de la cl&ocirc;ture de la connexion SQL ("+e+").");
       }
    }
}
