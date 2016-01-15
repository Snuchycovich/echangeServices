package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persons.Person;

public class LogOutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
			
			HttpSession session = req.getSession();
			Person person = (Person) session.getAttribute( "person" );
			if (person != null) {
				session.invalidate();
				resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath()+"/index.jsp"));
				return;
			}
	}
}
