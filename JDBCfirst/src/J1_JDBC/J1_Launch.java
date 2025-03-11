package J1_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class J1_Launch {

	public static void main(String[] args) {
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306";   // where is your RDMS
			String username="root";
			String password="Prince@0717";
			
			try {
				Connection con=DriverManager.getConnection(url,username,password);//upcasting , abstraction,Factory design patern
				System.out.println(con);
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
