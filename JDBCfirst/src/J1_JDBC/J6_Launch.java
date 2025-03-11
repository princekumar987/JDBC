package J1_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class J6_Launch {

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
					

					
					String sql="delete from jdbcfirst.employee where sn	<=15";
					Statement st=con.createStatement();
					
					int row =st.executeUpdate(sql);
					
					System.out.println(row);
							
							
					
//						while(rs.next()) {
//							 int sn=rs.getInt("sn");
//							 String getname=rs.getString("name");
//							 System.out.println(sn+" "+getname);
//						}
					
					
					
					
					
					
					
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
