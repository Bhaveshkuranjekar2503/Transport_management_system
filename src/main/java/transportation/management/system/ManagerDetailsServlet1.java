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
 * Servlet implementation class ManagerDetailsServlet1
 */
@WebServlet("/MDS")
public class ManagerDetailsServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerDetailsServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
	//	pw.println(id1);
		response.setContentType("text/html");
		try {
			int i = AdminDAO.deleteManager(id1);
			
			if(i>0) {
				pw.println("Manager details deleted successfully");
				request.getRequestDispatcher("ViewManager.jsp").include(request, response);
			}
			else {
				pw.println("Sorry ! Could not delete account");
				request.getRequestDispatcher("ViewManager.jsp").include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
