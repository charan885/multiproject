

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerRegistrationSuccess
 */
@WebServlet("/CustomerRegistrationSuccess")
public class CustomerRegistrationSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=  response.getWriter();
		out.println("<h1>Customer Registration success,please login</h1>");
		out.println("<a href='index.html'><h2>Home</h2></a> |");
		out.println("<a href='customerlogin.html'><h2>Customer Login</h2></a> |");
		
	}

}
