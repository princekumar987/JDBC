package J1_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class J2_Launch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306";   // where is your RDMS
			String username="root";
			String password="Prince@0717";
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);//upcasting , abstraction,Factory design patern
				System.out.println(con);
				
				//Database creation
				
//				String sql="create database jdbcfirst";
//				Statement st=con.createStatement();
//				st.execute(sql);
//				
//				System.out.println("Database created");
				
				
				
				//table creation
				
//				String sql="create table jdbcfirst.employee(sn int primary key,name varchar(40))";
//				Statement st=con.createStatement();
//				st.execute(sql);
//				
//				System.out.println("table created successfully");
				
				
				
				// Insertion ---sql query
				
				String name="maju";
				int sn=17;
				
				String sql="insert into jdbcfirst.employee(sn,name)  values("+sn+",'"+name+"')";
				Statement st=con.createStatement();
				st.execute(sql);
				
				System.out.println("data inserted successfully");
				
				
				
				
				
				
				
				
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
