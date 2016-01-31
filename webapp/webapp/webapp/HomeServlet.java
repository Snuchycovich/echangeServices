package webapp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HomeServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
		
		List<PSCompleteInfo> psCompleteInfo = null;
		try {
			psCompleteInfo = new DBHandler().SQLPSCompleteInfoDB.retrieveAll();
			Collections.reverse(psCompleteInfo);
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<PSCompleteInfo> servicesDemandes = new ArrayList<PSCompleteInfo>();
		List<PSCompleteInfo> servicesOffres = new ArrayList<PSCompleteInfo>();
		
		int indexDem = 0, indexOf = 0;
		for (PSCompleteInfo pscInfo : psCompleteInfo) {
			if( pscInfo.getStatus() == 0 ) {
				if (indexDem < 3){
					servicesDemandes.add(pscInfo);
					indexDem++;
				}
		    } else {
		    	if (indexOf < 3) {
		    		servicesOffres.add(pscInfo);
		    		indexOf++;
		    	}
		    }
		}
		req.setAttribute("listeServicesDemandes", servicesDemandes);
		req.setAttribute("listeServicesOffres", servicesOffres);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}
}
