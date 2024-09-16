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
import java.util.ArrayList;

/**
 * Servlet implementation class ComingTowardsTrucksServlet
 */
@WebServlet("/comingTrucks")
public class ComingTowardsTrucksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComingTowardsTrucksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		ServletContext sc = this.getServletContext();
		
		ManagerBean mb =(ManagerBean) sc.getAttribute("mb");
		
		 String branch = mb.getManagerBranch();
		 
		 ArrayList<TruckBean> tb = ManagerDAO.comingTrucks(branch);
		 
		 if(tb!=null) {
			 request.setAttribute("tableBean", tb);
			 request.getRequestDispatcher("Details.jsp").include(request, response);
		 }
		 else {
			 
			 out.println("we don't have information");
		 }
	}

}
