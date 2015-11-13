package webapp;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persons.*;

class SignInServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        this.log("Une exécution de la servlet...");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=null;
        try {
            out=resp.getWriter();
        } catch (IOException e) {
            out.close();
            throw e;
        }
        
        // Main operation
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        Person p = new Person(nom, prenom, email);
        
        //personsDBStub.create(p, password);
        /*String nom = req.getParameter("nom");
        out.println("<p>bonjour "+nom+"</p>");*/
  	}
}