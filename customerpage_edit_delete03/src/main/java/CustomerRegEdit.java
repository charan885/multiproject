

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customerpage.demo.Customer;
import com.customerpage.demo.CustomerDao;

/**
 * Servlet implementation class CustomerRegEdit
 */
@WebServlet("/CustomerRegEdit")
public class CustomerRegEdit extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("in customer Registration Edit servlet");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String customername=	request.getParameter("customername");
		String cid=         request.getParameter("cid");
		String password=	request.getParameter("passwordname");
		String phone=  request.getParameter("phone");
		String city= request.getParameter("city");
		String[] interestedin=   request.getParameterValues("shopname");
		
		Customer customer=new Customer();
		customer.setName(customername);
		customer.setPswd(password);
		customer.setId(Integer.parseInt(cid));
		customer.setPhone(Long.parseLong(phone));
		customer.setCity(city);
		
		String interested=null;
		for (int i=0;i<interestedin.length;i++) {
			interested=interested+","+interestedin[i];
		}
		interested=interested.replaceAll("null,", "");
		customer.setInterestedIn(interested);
		
		java.util.Date dob =new  java.util.Date();
		//customer.setCreatedDate(dob.toString());
		customer.setModifiedDate(dob.toString());
		
		if(CustomerDao.updateAllRecord(customer)>0) {
			response.sendRedirect("CustomerList");
		}else {
            response.sendRedirect("CustomerList");
		}
		
		/*
		 * if(CustomerDao.isCustomerExists(customer)) {
		 * //response.sendRedirect("CustomerRegistrationError");
		 * 
		 * }else { response.sendRedirect("CustomerList");
		 * 
		 * }
		 */

	}

}
