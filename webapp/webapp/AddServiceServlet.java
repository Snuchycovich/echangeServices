package webapp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Service;

public class AddServiceServlet extends HttpServlet{
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String type = req.getParameter("type");
		String category = req.getParameter("category");
		
		// Insert service into DB
		int idService = Integer.parseInt(id);
		Service service = new Service(idService,title,description,type,category);
		try {
            new ServicesDBHandler().getDb().create(service);
        } catch (Exception e) {
            this.terminate(req,res,"Erreur d'insertion dans la base ("+e+").");
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
        res.sendRedirect(res.encodeRedirectURL(req.getContextPath()+"/toc.jsp?message="+message));
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
