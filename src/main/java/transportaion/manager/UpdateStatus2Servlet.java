package transportaion.manager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class UpdateStatus2Servlet
 */
@WebServlet("/UpdateStatus2")
public class UpdateStatus2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStatus2Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int i = 0;
		String newStatus = request.getParameter("newStatus");
		String truckNumber = request.getParameter("truckNumber");

		try {
			 i = ManagerDAO.updatedNewStatus(newStatus, truckNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (i>0) {
			out.println("Status updated Successfully");
		//	request.getRequestDispatcher("UpdateStatus.jsp").include(request, response);
		} else {
			out.println("Status could not updated");
			//request.getRequestDispatcher("UpdateStatus.jsp").include(request, response);
		}
		request.getRequestDispatcher("UpdateStatus.jsp").include(request, response);
		
		
	}
}
