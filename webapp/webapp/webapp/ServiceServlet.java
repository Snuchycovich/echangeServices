package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String type = req.getParameter("type");
		String category = req.getParameter("category");
		String limitdate = req.getParameter("limitdate");
		
		req.setAttribute("title",title);
		req.setAttribute("description",description);
		req.setAttribute("type",type);
		req.setAttribute("category",category);
		req.setAttribute("limitdate",limitdate);
		
		req.getRequestDispatcher("/pages/service.jsp").forward(req, res);
	}
}
