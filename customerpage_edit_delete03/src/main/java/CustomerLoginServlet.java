

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customerpage.demo.Customer;
import com.customerpage.demo.CustomerDao;

/**
 * Servlet implementation class CustomerLoginServlet
 */
@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	System.out.println("in customer login servlet");
	String customerid=	request.getParameter("userid");
	String password=	request.getParameter("passwordname");
	//System.out.println(customerid+" "+password);
	
	Customer customer=new Customer();
	customer.setId(Integer.parseInt(customerid));
	customer.setPswd(password);
	
	response.setContentType("text/html");
	PrintWriter out=  response.getWriter();
	
	boolean islogin=     CustomerDao.customerLogin(customer);
	if(islogin) {
		//out.println("<html><head><title>customer login page</title></head><body><h1 style='color:red'>Customer login successfully</h1></body></html>");
           request.setAttribute("customerId", customer.getId());
           RequestDispatcher requestDispatcher  = request.getRequestDispatcher("CustomerLoginSuccess");
           requestDispatcher.forward(request, response);
		
	   }else {
			//out.println("<html><head><title>customer login page</title></head><body><h1 style='color:red'>Customer login failure,please register</h1></body></html>");
              response.sendRedirect("CustomerLoginError");
	   }
	//out.println("<a href='index.html'><h2>Home</h2></a>");

	}

}
