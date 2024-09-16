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
 * Servlet implementation class ContactUsServlet
 */
@WebServlet("/contactUs")
public class ContactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		long phone1 = Long.parseLong(phone);
		String message = request.getParameter("message");
		
		PrintWriter pw = response.getWriter();
		
		try {
			int i = ManagerDAO.ContactToAdmin(name,email,phone1,message);
			
			if(i>0) {
				pw.println("Ypur query submitted succesfully");
			}
			else {
				
				pw.println("Your message did not sumnit");
			}
			
			request.getRequestDispatcher("Contactus.html").include(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
