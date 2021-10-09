

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerLogout
 */
@WebServlet("/CustomerLogout")
public class CustomerLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//1.create session object
		HttpSession session=   request.getSession();
		//2.remove
		session.setAttribute("customerId", null);
		//3.expire
		session.invalidate();
		//4.redirect to login
		response.sendRedirect("customerlogin.html");
	}

}
