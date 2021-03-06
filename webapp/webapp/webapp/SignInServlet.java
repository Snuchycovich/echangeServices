package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persons.*;

public class SignInServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	        throws ServletException, IOException {
		req.getRequestDispatcher("/pages/signIn.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");

        // Main operation
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Person p = new Person(nom, prenom, email);

        try {
			// Insert service into DB
			 new DBHandler().SQLPersonDB.create(p, password);
        } catch (Exception e) {
            this.terminate(req,res,"Erreur d'insertion dans la base ("+e+").");
            e.printStackTrace();
            return;
        }
        // Everything went well
        this.terminate(req,res,"Votre inscription s'est déroulée avec succès, merci.");
        //res.sendRedirect("logIn");
  	}

	/**
     * Terminates the response of this servlet by displaying table of contents and a message.
     * @param request The request for this call
     * @param response The response for this call
     * @param message The message to be forwarded to table of contents
     */
    protected void terminate(HttpServletRequest req, HttpServletResponse res, String message) throws ServletException, IOException {
        //res.sendRedirect(res.encodeRedirectURL(req.getContextPath()+"/index.jsp?message="+message));
        res.sendRedirect("logIn");
    }
}
