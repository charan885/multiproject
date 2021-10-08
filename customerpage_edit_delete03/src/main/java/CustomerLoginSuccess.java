

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customerpage.demo.Customer;
import com.customerpage.demo.CustomerDao;

/**
 * Servlet implementation class CustomerLoginSuccess
 */
@WebServlet("/CustomerLoginSuccess")
public class CustomerLoginSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=  response.getWriter();
		
		int customerId=(Integer)request.getAttribute("customerId");
		HttpSession session=  request.getSession();
		session.setAttribute("customerId", customerId);
		
		Customer customer=new Customer();
		customer.setId(customerId);
		Customer selectCustomer=  CustomerDao.selectRecord(customer);
		
		out.println("<h1 style='color:red'>Hey "+customerId +" Customer login successfully</h1>");
		out.println("<a href='index.html'><h2>Home</h2></a> |");
		out.println("<a href='#'><h3>Here is your details :--</h3></a> |");
		
		out.println("<table border='2px' align='center' bgcolor='yellow' cellspacing='15px' cellpadding='10px'>");
		
		
		out.println("<tr><td><label>Name</label></td><td>"+selectCustomer.getName() +"</td></tr>");
		out.println("<tr><td><label>Customer Id</label></td><td>"+selectCustomer.getId() +"</td></tr>");
		out.println("<tr><td><label>Password</label></td><td>"+selectCustomer.getPswd() +"</td></tr>");
		out.println("<tr><td><label>Phone</label></td><td>"+selectCustomer.getPhone() +"</td></tr>");
		out.println("<tr><td><label>City</label></td><td>"+selectCustomer.getCity() +"</td></tr>");
		out.println("<tr><td><label>InterestedIn</label></td><td>"+selectCustomer.getInterestedIn() +"</td></tr>");
		out.println("<tr><td><label>CreatedDate</label></td><td>"+selectCustomer.getCreatedDate() +"</td></tr>");
		out.println("<tr><td><label>ModifiedDate</label></td><td>"+selectCustomer.getModifiedDate() +"</td></tr>");
		
		
		out.println("<table>");
		
		out.println("<a href='CustomerLogout'><h2>Logout</h2></a> |");
	}

}
