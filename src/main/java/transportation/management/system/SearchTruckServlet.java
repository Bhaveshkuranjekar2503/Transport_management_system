package transportation.management.system;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class SearchTruckServlet
 */

@WebServlet("/SearchTruck")
public class SearchTruckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTruckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String truckModel = request.getParameter("truckDetails");
		TruckBean tb=null;
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		try {
			 tb = AdminDAO.truckDetails(truckModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if(tb!=null) {
			request.setAttribute("tb",tb);
			request.getRequestDispatcher("ViewTruckDetails.jsp").forward(request, response);
		}
		else {
			pw.println("<h1>please enter valid details</h1>");
			pw.println("<h1>Enter truck number </h1>");
			request.getRequestDispatcher("FindTruck.jsp").include(request, response);
		}
	}

}
