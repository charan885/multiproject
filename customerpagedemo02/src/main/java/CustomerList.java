

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customerpage.demo.Customer;
import com.customerpage.demo.CustomerDao;

/**
 * Servlet implementation class CustomerList
 */
@WebServlet("/CustomerList")
public class CustomerList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=  response.getWriter();
		List<Customer> customersList=  CustomerDao.loadAllCustDetails();
		
		out.println("<h1 style='color:red'> Customer list</h1>");
		out.println("<table border='2px' align='center' bgcolor='yellow' cellspacing='15px' cellpadding='10px'>");
		out.println("<tr><td>Name</td>"
				+ "<td>CustomerId</td>"
				+ "<td>Password</td>"
				+ "<td>Phone</td>"
				+ "<td>City</td>"
				+ "<td>InterestedIn</td>"
				+ "<td>CreatedDate</td>"
				+ "<td>ModifiedDate</td>"
				+ "</tr>");
		
		
		for (Customer customer : customersList) {
			out.println("<tr><td>"+customer.getName()+"</td>"
					+ "<td>"+customer.getId()+"</td>"
					+ "<td>"+customer.getPswd()+"</td>"
					+ "<td>"+customer.getPhone()+"</td>"
					+ "<td>"+customer.getCity()+"</td>"
					+ "<td>"+customer.getInterestedIn()+"</td>"
					+ "<td>"+customer.getCreatedDate()+"</td>"
					+ "<td>"+customer.getModifiedDate()+"</td>"
					+ "</tr>");
		} 
			
		out.println("<table>");
		out.println("<a href='index.html'><h2>Home</h2></a> |");

	}

}
