package webapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persons.Person;

public class CycleServlet extends HttpServlet{
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		// If the user is not connected, he is redirected to the login page
		Person person = (Person) session.getAttribute( "person" );
		if (person == null) {
			res.sendRedirect(req.getContextPath()+"/logIn");
			return;
		}
		
		/*
		List<PersonServiceAssociation> listPsa = null;
		try {
			listPsa = new DBHandler().SQLPersonServiceDB.retrieveAll();
			Algo algo = new Algo();
			algo.run(person, service, psa);
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
		*/
		
	}
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
	

}
