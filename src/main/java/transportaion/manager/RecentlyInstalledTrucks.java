package transportaion.manager;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import transportation.management.system.TruckBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class RecentlyInstalledTrucks
 */
@WebServlet("/recentlyInstalledTrucks")
public class RecentlyInstalledTrucks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecentlyInstalledTrucks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("Recently installed trucks servlet");
		ServletContext sc = this.getServletContext();
		response.setContentType("text/html");
		int i=0;
		try {
			ArrayList<TruckBean> al = ManagerDAO.beforeOneMonthInstalledTrucks();
			sc.setAttribute("al", al);
			if(al!=null) {
				pw.println("data found");
				request.getRequestDispatcher("RecentlyInstalledTrucks.jsp").include(request, response);
			}
			else {
				pw.println("No records found ");
				request.getRequestDispatcher("Details.html").include(request, response);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
