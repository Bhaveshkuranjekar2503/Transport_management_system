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
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/managerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String branch = request.getParameter("branch");
		String userName = request.getParameter("uname");
		String password = request.getParameter("password");
		String DateOfJoining = request.getParameter("doj");
		String DateOfBirth = request.getParameter("dob");
		String salary = request.getParameter("sal");
		double salary1=Double.parseDouble(salary);
		String id=request.getParameter("id");
		int id1=Integer.parseInt(id);
		PrintWriter out=response.getWriter();
		int i=0;
		response.setContentType("text/html");
		try {
			 i = AdminDAO.registerManager(branch, userName, password, DateOfJoining, DateOfBirth, salary1,id1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(i>0) {
			out.println("Manager account created successfully");
			request.getRequestDispatcher("AdminLogin.jsp").include(request, response);
		}
		else {
			out.println("Manager account could not created Please Retry");
			request.getRequestDispatcher("AdminLogin.jsp").include(request, response);
		}
	}

}
