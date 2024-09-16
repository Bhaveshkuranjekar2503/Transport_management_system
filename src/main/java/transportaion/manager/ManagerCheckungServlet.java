package transportaion.manager;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class ManagerCheckungServlet
 */
@WebServlet("/manager")
public class ManagerCheckungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String branch = request.getParameter("branch");
		String uname = request.getParameter("username");
		String password = request.getParameter("password");

		ManagerBean mb=new ManagerBean();
		ServletContext sc = this.getServletContext();
		
		mb.setManagerBranch(branch);
		
		sc.setAttribute("mb", mb);
		int i = 0;
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		try {
			i = ManagerDAO.loginManager(branch, uname, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (i > 0) {
			request.getRequestDispatcher("Details.html").forward(request, response);
		} else {

			pw.println("<h1>Sorry ! username and password error please enter correct details</h1>");
			request.getRequestDispatcher("Index.html").include(request, response);
			
		}
	}

}
