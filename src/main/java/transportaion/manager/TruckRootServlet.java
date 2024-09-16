package transportaion.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import transportation.management.system.TruckBean;

/**
 * Servlet implementation class TruckRootServlet
 */
@WebServlet("/trs")
public class TruckRootServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TruckRootServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String startingPoint = request.getParameter("StartingPoint");
		String endingPoint = request.getParameter("EndingPoint");
		PrintWriter out = response.getWriter();
		HttpSession hs = request.getSession();

		ArrayList<TruckBean> al = ManagerDAO.rootOfTruck(startingPoint, endingPoint);
		hs.setAttribute("al", al);
		if (al != null && !al.isEmpty()) {

			request.getRequestDispatcher("TruckRoot2.jsp").include(request, response);
		} else {
			out.println("Sorry, no trucks found for the selected route.");
			request.getRequestDispatcher("Details.html").include(request, response);
		}
	}
}
