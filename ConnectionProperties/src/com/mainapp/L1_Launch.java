package com.mainapp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class L1_Launch {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		 try {
		     
			 while(true) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
//				String url="jdbc:mysql://localhost:3306";   // where is your RDMS
//				String username="root";
//				String password="Prince@0717";
				
				FileInputStream fis=new FileInputStream("C:\\Users\\princ\\OneDrive\\Desktop\\Demo\\abc.txt");
				Properties p=new Properties();
				p.load(fis);
				
				String url=(String) p.get("url");
				String username=(String) p.get("username");
				String password=(String) p.get("password");
				
				try {
					
					Connection con=DriverManager.getConnection(url,username,password);//upcasting , abstraction,Factory design patern
					System.out.println(con);
					

					
					String sql="select * from industrial.employee";
					PreparedStatement ps=con.prepareStatement(sql);					
					ResultSet rs =ps.executeQuery(sql);
					
					
						
					
						while(rs.next()) {
							 int eid=rs.getInt("eid");
							 String getename=rs.getString("ename");
							 String getephone=rs.getString("ephone");
							 int getesalary=rs.getInt("esal");
							 
							 System.out.println(eid+" "+getename+" "+getephone+" "+getesalary);
						}
						Thread.sleep(2000);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					
				}
					
				
			} 
			catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}



	}

}
