package com.customerpage.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CustomerDao {

	static Connection con = null;
	
	static {
		con = DBConnection.getDbCon();
	}

	public static int createRecord() {
		int temp = 0;
		try {
			//con = DBConnection.getDbCon();
			System.out.println(con);
			Statement statement = con.createStatement();
			String myQuery = "create table customers(id int primary key ,password varchar(30) not null ,name varchar(30) not null ,phone long not null,city varchar(30) not null,interestedin varchar(50) not null,createdDate varchar(50) ,modifieddate varchar(50) )";
			temp = statement.executeUpdate(myQuery);
			statement.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	public static int insertRecord(Customer cust) {
		int temp = 0;
		PreparedStatement pst=null;
		try {
			con = DBConnection.getDbCon();
			System.out.println("insert con method---"+con);
			 pst = con.prepareStatement("insert into customers values(?,?,?,?,?,?,?,?)");
			pst.setInt(1, cust.getId());
			pst.setString(2, cust.getPswd());
			pst.setString(3, cust.getName());
			pst.setLong(4, cust.getPhone());
			pst.setString(5, cust.getCity());
			pst.setString(6, cust.getInterestedIn());
			pst.setString(7, cust.getCreatedDate());
			pst.setString(8, cust.getModifiedDate());
			
			temp = pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pst!=null)
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(con!=null)
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}

	public static int updateRecord(Customer cust) {
		int temp = 0;
		try {
			 con = DBConnection.getDbCon();

			PreparedStatement mystatement = con.prepareStatement("update customers set name=? where id=?");

			// mystatement.setString(2, cust.getPswd());
			mystatement.setString(1, cust.getName());
			mystatement.setInt(2, cust.getId());
			// mystatement.setLong(4, cust.getPhone());
			// mystatement.setString(5, cust.getCity());
			temp = mystatement.executeUpdate();
			con.close();
			mystatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	public static int updateAllRecord(Customer cust) {
		int temp = 0;
		PreparedStatement pst=null;
		try {
			 con = DBConnection.getDbCon();

			 pst = con.prepareStatement("update customers set name=?,password=?,phone=?,city=?,interestedin=?,modifieddate=? where id=?");

			pst.setString(1, cust.getName());
			pst.setString(2, cust.getPswd());
			pst.setLong(3, cust.getPhone());
			pst.setString(4, cust.getCity());
			pst.setString(5, cust.getInterestedIn());
			pst.setString(6, cust.getModifiedDate());
			pst.setInt(7, cust.getId());
			
			temp = pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return temp;
	}
	public static int deleteRecord(Customer cust) {
		int temp = 0;
		try {
			 con = DBConnection.getDbCon();

			PreparedStatement mystatement = con.prepareStatement("delete from customers  where id=?");

			// mystatement.setString(2, cust.getPswd());
			// mystatement.setString(1, cust.getName());
			mystatement.setInt(1, cust.getId());
			// mystatement.setLong(4, cust.getPhone());
			// mystatement.setString(5, cust.getCity());
			temp = mystatement.executeUpdate();
			con.close();
			mystatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public static Customer selectRecord(Customer cust) {
		//int temp=0;
		ResultSet resultset=null;
		Customer customer=new Customer();
		PreparedStatement pst=null;
		try {
		 con =    DBConnection.getDbCon();
		 pst= con.prepareStatement("select * from customers where id=?");
		 pst.setInt(1, cust.getId());
		 resultset=pst.executeQuery();
		 if(resultset.next()) {
			// for(int i=1;i<=5;i++) {
				// System.out.print(resultset.getString(i)+"\t");
				 customer.setId(resultset.getInt(1));
				 customer.setPswd(resultset.getString(2));
				 customer.setName(resultset.getString(3));
				 customer.setPhone(resultset.getLong(4));
				 customer.setCity(resultset.getString(5));
				 customer.setInterestedIn(resultset.getString(6));
				 customer.setCreatedDate(resultset.getString(7));
				 customer.setModifiedDate(resultset.getString(8));
			// }
			// System.out.println();
		 }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pst!=null) {
				pst.close();
				}
				if(con!=null) {
				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customer;
	}
	
	public static List<Customer> loadAllCustDetails() {
		//int temp=0;
		ResultSet resultset=null;
		Customer customer=null;
		PreparedStatement pst=null;
		List<Customer> customers=new ArrayList<Customer>();
		try {
		 con =    DBConnection.getDbCon();
		 pst= con.prepareStatement("select * from customers");
		 //pst.setInt(1, cust.getId());
		 resultset=pst.executeQuery();
		 while(resultset.next()) {
			     customer=new Customer();

			// for(int i=1;i<=5;i++) {
				// System.out.print(resultset.getString(i)+"\t");
				 customer.setId(resultset.getInt(1));
				 customer.setPswd(resultset.getString(2));
				 customer.setName(resultset.getString(3));
				 customer.setPhone(resultset.getLong(4));
				 customer.setCity(resultset.getString(5));
				 customer.setInterestedIn(resultset.getString(6));
				 customer.setCreatedDate(resultset.getString(7));
				 customer.setModifiedDate(resultset.getString(8));
				 
				 customers.add(customer);
			// }
			// System.out.println();
		 }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pst!=null)
				pst.close();
				if(con!=null)
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customers;
	}
	
	
	public static boolean isCustomerExists(Customer cust) {
		boolean res=false;
		ResultSet resultset=null;
		PreparedStatement pst=null;
		try {
			 //con =    DBConnection.getDbCon();
			pst= con.prepareStatement("select * from customers where id=?");
		 pst.setInt(1, cust.getId());
		// mystatement.setString(2, cust.getPswd());
		// mystatement.setString(3, cust.getName());
		// mystatement.setLong(4, cust.getPhone());
		// mystatement.setString(5, cust.getCity()); 
		 resultset=pst.executeQuery();
		// System.out.println(resultset.next());
		 res=resultset.next();
		 System.out.println("result set data exist---"+res);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pst!=null)
				pst.close();
				if(con!=null)
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public static boolean isCustomerLogin(Customer cust) {
		boolean res=false;
		ResultSet resultset=null;
		try {
			 //con =    DBConnection.getDbCon();
		 PreparedStatement pst= con.prepareStatement("select * from customers where name = ? and password=? ");
		 //pst.setInt(1, cust.getId());
		 pst.setString(1, cust.getName());
		 pst.setString(2, cust.getPswd());
		 
		// mystatement.setLong(4, cust.getPhone());
		// mystatement.setString(5, cust.getCity()); 
		 resultset=pst.executeQuery();
		// System.out.println(resultset.next());
		 res=resultset.next();
		 System.out.println("result set data exist---"+res);
		pst.close();
		con.close();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	
	
	public static boolean customerLogin(Customer cust) {
		boolean res=false;
		ResultSet resultset=null;
		PreparedStatement pst=null;
		try {
	     con =    DBConnection.getDbCon();
		 pst= con.prepareStatement("select * from customers where id=? and password=?");
		 pst.setInt(1, cust.getId());
		 pst.setString(2, cust.getPswd());
		 
		 resultset=pst.executeQuery();
		// System.out.println(resultset.next());
		 res=resultset.next();
		 System.out.println("result set data exist---"+res);
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				if(pst!=null)
				pst.close();
				if(con!=null)
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return res;
	}
	
	
	public static String forgotPassword(Customer cust) {
		boolean res=false;
		ResultSet resultset=null;
		String passwdstr=null;
		try {
			 //con =    DBConnection.getDbCon();
		 PreparedStatement pst= con.prepareStatement("select passwd from customers where id=? or phone=?");
		 pst.setInt(1, cust.getId());
		 pst.setLong(2, cust.getPhone());
		// mystatement.setString(3, cust.getName());
		// mystatement.setLong(4, cust.getPhone());
		// mystatement.setString(5, cust.getCity()); 
		 resultset=pst.executeQuery();
		// System.out.println(resultset.next());
		 res=resultset.next();
		 //ResultSetMetaData resultSetMetaData=	 resultset.getMetaData();
		 if(res) {
			 //while(res) {
				// for(int i=1;i<=resultSetMetaData.getColumnCount();i++) {
					 System.out.print("your password is  :--"+" "   +resultset.getString(1)+"\t");
				// } 
					 passwdstr=resultset.getString(1);
				 System.out.println();
				 System.out.println("-----------");
			 // }
		 }else {
			 System.out.println("Invalid id or phone");

		 }
		 
		 System.out.println("result set data exist---"+res);
		pst.close();
		con.close();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return passwdstr;
	}
	
	public static Customer forgotCustomerUserIdandPassword(Customer cust) {
		boolean res=false;
		ResultSet resultset=null;
		Customer custData=new Customer();
		try {
			 //con =    DBConnection.getDbCon();
		 PreparedStatement pst= con.prepareStatement("select id,passwd from customers where  phone=?");
		// pst.setInt(1, cust.getId());
		// pst.setString(2, cust.getPswd());
		// mystatement.setString(3, cust.getName());
		 pst.setLong(1, cust.getPhone());
		// mystatement.setString(5, cust.getCity()); 
		 resultset=pst.executeQuery();
		// System.out.println(resultset.next());
		 res=resultset.next();
		 ResultSetMetaData resultSetMetaData=	 resultset.getMetaData();
		 if(res) {
			 //while(res) {
				// for(int i=1;i<=resultSetMetaData.getColumnCount();i++) {
					 System.out.print("Id is :---"+" "   +resultset.getString(1)+"\t");
					 System.out.print("Password is :---"+" "   +resultset.getString(2)+"\t");
					 custData.setId(resultset.getInt(1));
					 custData.setPswd(resultset.getString(2));
				// } 
				 System.out.println();
				 System.out.println("-----------");
			 // }
		 }else {
			 System.out.println("Invalid Phone");

		 }
		 System.out.println("result set data exist---"+res);
		pst.close();
		con.close();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return custData;
	}
	
	public static void showAllCustByNamesAsc() {
		//boolean res=false;
		ResultSet resultset=null;
		try {
			 //con =    DBConnection.getDbCon();
		 PreparedStatement pst= con.prepareStatement("select * from customers order by name asc");
		 resultset=pst.executeQuery();
		
		 ResultSetMetaData resultSetMetaData=    resultset.getMetaData();
		 for(int i=1;i<=resultSetMetaData.getColumnCount();i++) {
			 System.out.print(resultSetMetaData.getColumnName(i)+"\t");
		 }
		 System.out.println("");
		 System.out.println("----------------------------------------");
		 
		 while(resultset.next()) {
			 for(int i=1;i<=5;i++) {
				 System.out.print(resultset.getString(i)+"\t");
			 }
			 System.out.println();
			 System.out.println("-------------------------------------");
		 }
		pst.close();
		con.close();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//return res;
	}

	public static void main(String[] args) {
			/* System.out.println(CustomerDao.createRecord()==0?"Table is created":"Error while creating table");

		 Customer customer = new Customer(301, "paswd1", "cname", 9874566L, "hyd","clothes,electronics,arts",(new Date()).toString(),(new Date()).toString());
		int insertrecordresult = CustomerDao.insertRecord(customer);
		System.out.println(insertrecordresult == 1 ? "successfully inserted " : "error in insertion");

		
		  Customer updatecustomer=new Customer(301,"paswd1","cname2",9874566L,"hyd"); 
		int  updaterecordresult=CustomerDao.updateRecord(updatecustomer);
		  System.out.println(updaterecordresult==1?"successfully updated "
		  :"error in updated");
		  
		 Customer deletecustomer=new Customer(301,"paswd1","cname2",9874566L,"hyd"); 
		int  deleterecordresult=CustomerDao.deleteRecord(deletecustomer);
		 System.out.println(deleterecordresult==1?"successfully deleted "
		 :"error in deleted");
		 
		
		Customer customer=new Customer(301,"paswd1","cname",9874566L,"hyd");
		CustomerDao.selectRecord(customer);
		
		Customer customer=new Customer(301,"paswd1","cname",9874566L,"hyd");
	    Customer custid=	CustomerDao.selectRecord(customer);
	    System.out.println(custid);
		
		 List<Customer> custData=	CustomerDao.loadAllCustDetails();
		    System.out.println(custData);*/
		
	/*	Customer updatecustomer=new Customer(302,"paswd1","cname2",9874566L,"hyd"); 
		
		if(isCustomerExists(updatecustomer)) {
			int updaterecordresult=CustomerDao.updateRecord(updatecustomer);
			  System.out.println(updaterecordresult==1?"successfully updated "
			  :"error in updated");
		}else {
		System.out.println("Record doesn't exist");
		}
		  
		 Customer deletecustomer=new Customer(302,"paswd1","cname2",9874566L,"hyd"); 
		 
		 if(isCustomerExists(deletecustomer)) {
			 int deleterecordresult=CustomerDao.deleteRecord(deletecustomer);
			 System.out.println(deleterecordresult==1?"successfully deleted "
			 :"error in deleted");
			}else {
			System.out.println("Record doesn't exist");
			}
		
		
		Customer customer=new Customer(301,"paswd1","cname",9874566L,"hyd");
		boolean islogin=  CustomerDao.customerLogin(customer);
		if(islogin) {
			System.out.println("Successful login");
		}else {
			System.out.println("error in  login");
		}
		
		Customer forgtCustPaswd=new Customer(301,null,null,9874566L,null);
		CustomerDao.forgotPassword(forgtCustPaswd);
		
		Customer forgtCustUserIdandPaswd=new Customer(0,null,null,9874566L,null);
	Customer custidandpaswd=	CustomerDao.forgotCustomerUserIdandPassword(forgtCustUserIdandPaswd);
	System.out.println(custidandpaswd);*/
		/*	
	Customer forgtCustUserIdandPaswd=new Customer(0,null,null,9874566L,null);
		CustomerDao.forgotCustomerUserIdandPassword(forgtCustUserIdandPaswd);
		
      System.out.println("--Show all customer  data in ascending order by names --");
		CustomerDao.showAllCustByNamesAsc();
		*/
	}

}
