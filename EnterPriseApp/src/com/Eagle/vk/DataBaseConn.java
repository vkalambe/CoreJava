package com.Eagle.vk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConn {
	 Connection conn;
      public DataBaseConn() throws ClassNotFoundException {
    	  Class.forName("com.mysql.jdbc.Driver");	
    	  }
	public Connection getconn() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","root");
	
	
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(conn);
		return conn;
	}
	
}
