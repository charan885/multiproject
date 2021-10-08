

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
 * Servlet implementation class AdminCustomerEdit
 */
@WebServlet("/AdminCustomerEdit")
public class AdminCustomerEdit extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		          response.setContentType("text/html");
		          PrintWriter out=response.getWriter();
		          
		          String customerid=    request.getParameter("customerid");
				  int customerData=  Integer.parseInt(customerid);
				  Customer customer=new Customer();
				  customer.setId(customerData);
				  
				  Customer customerdata=  CustomerDao.selectRecord(customer);
				  
				  out.println("<html><head>"
				  		+ "      <title>customer registration edit example</title>");
				  out.println("<script type='text/javascript' src='./scripts.js'></script>");
				  out.println("<link rel='stylesheet' href='styles.css'></link>");
				  out.println("</head>");
				  out.println("<body>"
				  		+ "     <header><h1>Welcome to ABC shopping</h1> "
				  		+ "         <nav>"
				  		+ "            <a href='index.html'>"
				  		+ "                Home"
				  		+ "            </a>   |"
				  		+ "            <a href='about.html'>"
				  		+ "                 About"
				  		+ "            </a>  |"
				  		+ "              <a href='contact.html'>"
				  		+ "                ContactUs"
				  		+ "              </a> |"
				  		+ "              <a href='customerlogin.html'>"
				  		+ "                Customer Login"
				  		+ "              </a> |"
				  		+ ""
				  		+ "              <a href='#'>"
				  		+ "                Customer Registration"
				  		+ "              </a> |"
				  		+ ""
				  		+ "              <a href='CustomerList'>"
				  		+ "                Customer Data"
				  		+ "              </a> "
				  		+ "         </nav>"
				  		+ "     </header>"
				  		+ "<hr>");
				  out.println("<form name='customereditform' action='CustomerRegEdit' method='GET'>");
				  out.println("<table border='2px' align='center' bgcolor='yellow' cellspacing='15px' cellpadding='10px'>");
				  out.println("<caption>Customer Registration Edit</caption>");
				  out.println(" <tr>"
				  		+ "           <td><label for='customername'>Name</label></td>"
				  		+ "           <td><input type='text' id='customername' name='customername' value='"+customerdata.getName()+"' onblur='sfullname()'></td>"
				  		+ "    </tr>");
				  out.println("");
				  out.println("<tr>"
				  		+ "           <td><label for='cid'>Customer Id</td>"
				  		+ "           <td><input type='text' id='cid' name='cid' value='"+customerdata.getId()+"' readonly='readonly'></td>"
				  		+ "    </tr>");
				  out.println("");
				  out.println("<tr>"
				  		+ "            <td><label for='passwordid'>Password</td>"
				  		+ "            <td><input type='password' id='passwordid' name='passwordname' value='"+customerdata.getPswd()+"'></td>"
				  		+ "    </tr>");
				  out.println("");
				  out.println("<tr>"
				  		+ "            <td><label for='phone'>Phone</td>"
				  		+ "            <td><input type='text' id='phone' name='phone' value='"+customerdata.getPhone()+"'></td>"
				  		+ "   </tr>");
				  out.println("");
				  out.println("<tr>\r\n"
				  		+ "             <td><label for='city'>City</td>"
				  		+ "             <td><input type='text' id='city' name='city' value='"+customerdata.getCity()+"'></td>"
				  		+ "    </tr>");
				  out.println("");
				  String interested =customerdata.getInterestedIn();
				  String[] interestedin= {};
				  if(interested!=null && interested!="") {
					   interestedin = interested.split(","); 
				  }
				  
				  if(interestedin.length==0||interested==null ||interested=="") {
					  out.println("<tr>"
						  		+ "             <td><label for='shopid'>InterestedIn</td>"
						  		+ "             <td><input type='checkbox' value='Clothes' id='shopid' name='shopname' >Clothes&nbsp;"
						  		+ "                 <input type='checkbox' value='Electronics' id='shopid' name='shopname'>Electronics&nbsp;"
						  		+ "                 <input type='checkbox' value='Arts' id='shopid' name='shopname'>Arts&nbsp;</td>"
						  		+ "</tr>");
				  }else {
				  
				   // while(interestedin.length>0) {
				    	if(interestedin.length==1 && interestedin[0].equalsIgnoreCase("Clothes")) {
				    		 out.println("<tr>"
								  		+ "             <td><label for='shopid'>InterestedIn</td>"
								  		+ "             <td><input type='checkbox' value='Clothes' id='shopid' name='shopname' checked='checked'>Clothes&nbsp;"
								  		+ "                 <input type='checkbox' value='Electronics' id='shopid' name='shopname'>Electronics&nbsp;"
								  		+ "                 <input type='checkbox' value='Arts' id='shopid' name='shopname'>Arts&nbsp;</td>"
								  		+ "</tr>");
				    	}
				    	if(interestedin.length==1 && interestedin[0].equalsIgnoreCase("Electronics")) {
				    		 out.println("<tr>"
								  		+ "             <td><label for='shopid'>InterestedIn</td>"
								  		+ "             <td><input type='checkbox' value='Clothes' id='shopid' name='shopname' >Clothes&nbsp;"
								  		+ "                 <input type='checkbox' value='Electronics' id='shopid' name='shopname' checked='checked'>Electronics&nbsp;"
								  		+ "                 <input type='checkbox' value='Arts' id='shopid' name='shopname'>Arts&nbsp;</td>"
								  		+ "</tr>");
				    	}
				    	if(interestedin.length==1 && interestedin[0].equalsIgnoreCase("Arts")) {
				    		 out.println("<tr>"
								  		+ "             <td><label for='shopid'>InterestedIn</td>"
								  		+ "             <td><input type='checkbox' value='Clothes' id='shopid' name='shopname' >Clothes&nbsp;"
								  		+ "                 <input type='checkbox' value='Electronics' id='shopid' name='shopname'>Electronics&nbsp;"
								  		+ "                 <input type='checkbox' value='Arts' id='shopid' name='shopname' checked='checked'>Arts&nbsp;</td>"
								  		+ "</tr>");
				    	}
						/*
						 * else { out.println("<tr>" +
						 * "             <td><label for='shopid'>InterestedIn</td>" +
						 * "             <td><input type='checkbox' value='Clothes' id='shopid' name='shopname' >Clothes&nbsp;"
						 * +
						 * "                 <input type='checkbox' value='Electronics' id='shopid' name='shopname'>Electronics&nbsp;"
						 * +
						 * "                 <input type='checkbox' value='Arts' id='shopid' name='shopname'>Arts&nbsp;</td>"
						 * + "</tr>"); }
						 */
				    	
				    	
				    	if(interestedin.length==2 &&( interestedin[0].equalsIgnoreCase("Clothes") &&  interestedin[1].equalsIgnoreCase("Electronics") )) {
				    		 out.println("<tr>"
								  		+ "             <td><label for='shopid'>InterestedIn</td>"
								  		+ "             <td><input type='checkbox' value='Clothes' id='shopid' name='shopname' checked='checked'>Clothes&nbsp;"
								  		+ "                 <input type='checkbox' value='Electronics' id='shopid' name='shopname'checked='checked'>Electronics&nbsp;"
								  		+ "                 <input type='checkbox' value='Arts' id='shopid' name='shopname'>Arts&nbsp;</td>"
								  		+ "</tr>");
				    	}
				    	if(interestedin.length==2 &&( interestedin[0].equalsIgnoreCase("Clothes") &&  interestedin[1].equalsIgnoreCase("Arts") )) {
				    		 out.println("<tr>"
								  		+ "             <td><label for='shopid'>InterestedIn</td>"
								  		+ "             <td><input type='checkbox' value='Clothes' id='shopid' name='shopname' checked='checked'>Clothes&nbsp;"
								  		+ "                 <input type='checkbox' value='Electronics' id='shopid' name='shopname' >Electronics&nbsp;"
								  		+ "                 <input type='checkbox' value='Arts' id='shopid' name='shopname' checked='checked'>Arts&nbsp;</td>"
								  		+ "</tr>");
				    	}
				    	if(interestedin.length==2 &&( interestedin[0].equalsIgnoreCase("Electronics") &&  interestedin[1].equalsIgnoreCase("Arts") )) {
				    		 out.println("<tr>"
								  		+ "             <td><label for='shopid'>InterestedIn</td>"
								  		+ "             <td><input type='checkbox' value='Clothes' id='shopid' name='shopname' >Clothes&nbsp;"
								  		+ "                 <input type='checkbox' value='Electronics' id='shopid' name='shopname' checked='checked'>Electronics&nbsp;"
								  		+ "                 <input type='checkbox' value='Arts' id='shopid' name='shopname' checked='checked'>Arts&nbsp;</td>"
								  		+ "</tr>");
				    	}
				    	
				    	if(interestedin.length==3 &&( interestedin[0].equalsIgnoreCase("Clothes") &&  interestedin[1].equalsIgnoreCase("Electronics") &&  interestedin[2].equalsIgnoreCase("Arts"))) {
				    		 out.println("<tr>"
								  		+ "             <td><label for='shopid'>InterestedIn</td>"
								  		+ "             <td><input type='checkbox' value='Clothes' id='shopid' name='shopname' checked='checked'>Clothes&nbsp;"
								  		+ "                 <input type='checkbox' value='Electronics' id='shopid' name='shopname' checked='checked'>Electronics&nbsp;"
								  		+ "                 <input type='checkbox' value='Arts' id='shopid' name='shopname' checked='checked'>Arts&nbsp;</td>"
								  		+ "</tr>");
				    	}
				    	
				  //  }
				  }
				  
					/*
					 * out.println("<tr>" + "             <td><label for='shopid'>InterestedIn</td>"
					 * +
					 * "             <td><input type='checkbox' value='Clothes' id='shopid' name='shopname'>Clothes&nbsp;"
					 * +
					 * "                 <input type='checkbox' value='Electronics' id='shopid' name='shopname'>Electronics&nbsp;"
					 * +
					 * "                 <input type='checkbox' value='Arts' id='shopid' name='shopname'>Arts&nbsp;</td>"
					 * + "   </tr>");
					 */
				  out.println("");
				  out.println("<tr>"
				  		+ "             <td><input type='submit' name='submit' id='submit' value='Edit&Save'></td>"
				  		+ "             <td><input type='reset' name='submit' id='submit' value='clear'></td>"
				  		+ "    </tr>");
				  out.println("</table>");
				  out.println(" </form>");
				  out.println("<br><br>"
				  		+ "     <hr>"
				  		+ "     <footer>"
				  		+ "         <h3>Copyright@Sai</h3>"
				  		+ "     </footer></body></html");
				  
				  
		
	}

}
