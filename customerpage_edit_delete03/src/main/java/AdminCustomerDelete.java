

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customerpage.demo.Customer;
import com.customerpage.demo.CustomerDao;

/**
 * Servlet implementation class AdminCustomerDelete
 */
@WebServlet("/AdminCustomerDelete")
public class AdminCustomerDelete extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		  String customerid=    request.getParameter("customerid");
		  int customerData=  Integer.parseInt(customerid);
		  Customer customer=new Customer();
		  customer.setId(customerData);
		  
		  int customerObj = CustomerDao.deleteRecord(customer);
		  if(customerObj>0) {
			  response.sendRedirect("CustomerList");
		  }else {
			  response.sendRedirect("CustomerList");
		  }
		
	}

}
