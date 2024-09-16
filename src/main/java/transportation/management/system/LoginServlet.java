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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		int i=0;
		try{
			 i = AdminDAO.adminLogin(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(i>0) {
			out.println("Admin login successfully");
			request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
		}
		else {
			out.print("Sorry !Admin Username and password error "
					+ "Please enter correct details");
			request.getRequestDispatcher("Login.jsp").include(request, response);
			
			
		}
	}

}
