package com.mainapp;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class L1_Launch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
       try {
		     
			 
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				String url="jdbc:mysql://localhost:3306";   // where is your RDMS
				String username="root";
				String password="Prince@0717";
				
				
				try {
					
					Connection con=DriverManager.getConnection(url,username,password);//upcasting , abstraction,Factory design patern
					
					con.setAutoCommit(false);

					
					String sql="insert into industrial.employee (ename,ephone,esal) values(?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);	
					
					ps.setString(1, "ashish");
					ps.setString(2,"356788");
					ps.setInt(3, 6988);
					
					int row=ps.executeUpdate();
					System.out.println(row);
					
					
					System.out.println("Enter * to perform file operation");
					
					char ch=sc.next().charAt(0);
					if(ch=='*') {
						System.out.println("file inserted");
						con.commit();
					}
					else {
						System.out.println("file not inserted");
						con.rollback();
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					
				
			} 
			catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}



	}

}
