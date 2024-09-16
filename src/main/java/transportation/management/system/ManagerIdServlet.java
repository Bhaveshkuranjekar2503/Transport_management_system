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
 * Servlet implementation class ManagerIdServlet
 */
public class ManagerIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerIdServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean ub=null;
		int mid=ub.getManagerId();
		PrintWriter pw = response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("mid"));
		
		try {
			ub=AdminDAO.viewManagerAlldetail(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(ub!=null)
		{
			pw.println(ub.getManagerName());
			pw.println(ub.getManagerId());
			pw.println(ub.getPassword());
			pw.println(ub.getDateOfJoining());
			pw.println(ub.getDateOfBirth());
			pw.println(ub.getSalary());
		}
		
		
	}

}
