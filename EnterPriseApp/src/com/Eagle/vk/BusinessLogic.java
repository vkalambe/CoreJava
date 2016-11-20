package com.Eagle.vk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BusinessLogic  {
	String query;
	Statement stmt;
	Connection conn;
	 public BusinessLogic() {
	
	}
	public void Deposit(String name,int amount) throws ClassNotFoundException {
		try {
			
	
	
			stmt=conn.createStatement();
			
		query = "update exam1 set balance=balance+" + amount
				+ " where name='" + name + "'";
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Withdraw(String name,int amount) {
		try {
			stmt=conn.createStatement();
			query = "update exam1 set balance=balance-" + amount
					+ " where name='" + name + "'";
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void Details(String name) {
		try {
		query="select balance from exam1 where name= "+name;
		stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
