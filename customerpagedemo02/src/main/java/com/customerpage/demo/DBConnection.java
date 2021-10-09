package com.customerpage.demo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	public static Connection getDbCon()   {
		Connection dbCon=null;
		Properties prop=new Properties();
		try {
		//FileInputStream	fis=new FileInputStream("DBConnection.properties");
		//prop.load(fis);
		//Class.forName(prop.getProperty("h2_driver_class_name"));
		Class.forName("org.h2.Driver");
		// dbCon =DriverManager.getConnection("jdbc:h2:mem:books_data", "sa", null);
		// dbCon =DriverManager.getConnection(prop.getProperty("h2_driver_url"), prop.getProperty("h2_username"), "");
		 dbCon =DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		 System.out.println("in getdbcon dbcon ---"+dbCon);

		}catch (Exception e) {
			System.out.println("getDBCon method----"+e.getMessage());
		}
		return dbCon;
		
	}

	public static void main(String[] args) {
     
		Connection dbCon=	getDbCon();
		try {
			System.out.println(dbCon.createStatement());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
