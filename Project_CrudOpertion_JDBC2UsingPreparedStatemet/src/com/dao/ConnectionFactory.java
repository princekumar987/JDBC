package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	@SuppressWarnings("finally")
	
	public static Connection getCon() {
		
		Connection con=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306";
			String username="root";
			String password="Prince@0717";
			
			con=DriverManager.getConnection(url,username,password);
						
		}
		catch(Exception e) {
	
			System.out.println(e);
	
		}
		finally{
			
			return con;
			
		}
	}

}
