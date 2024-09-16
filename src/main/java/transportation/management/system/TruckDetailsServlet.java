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
 * Servlet implementation class TruckDetailsServlet
 */
@WebServlet("/truckDetailsServlet")
public class TruckDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String truckModel = request.getParameter("truckmodel");
		String truckNumber = request.getParameter("truckNumber");
		String choice = request.getParameter("choice");
		String insuranceCompanyName = request.getParameter("insuranceCompany");
		String ownerName = request.getParameter("ownerName");
		String mobileNumber = request.getParameter("mno");
		long mobileNumber1=Long.parseLong(mobileNumber);
		
		String staringPoint = request.getParameter("branch1");
		String endingPoint=request.getParameter("branch2");
		String joiningDate = request.getParameter("joiningDate");
		
		
		response.setContentType("text/html");
		int i=0;
		PrintWriter out = response.getWriter();
		
		try {
			 i = AdminDAO.truckRegister(truckModel,truckNumber,choice,insuranceCompanyName,ownerName,mobileNumber1,staringPoint,endingPoint,joiningDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(i>0) {
			out.println("Truck details inserted successfully");
			request.getRequestDispatcher("AdminLogin.jsp").include(request, response);
		}
		else {
			out.println("Truck details didn't inserted");
			request.getRequestDispatcher("AdminLogin.jsp").include(request, response);
		}
	}

}
