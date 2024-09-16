package transportation.management.system;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class FindingManagerDetailsServlet
 */
@WebServlet("/findingManager")
public class FindingManagerDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindingManagerDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String managerName = request.getParameter("managerName");
		
		ArrayList<UserBean> al=null;
		PrintWriter out = response.getWriter();
		try {
			  al = AdminDAO.findingManager(managerName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	if(al!=null) {
		request.setAttribute("ub",al);
		request.getRequestDispatcher("ViewManager.jsp").forward(request, response);
	}
	else {
		out.println("Sorry details not found of name "+managerName);
		request.getRequestDispatcher("AadminLogin.jsp").include(request, response);
	}
}
	
	
}