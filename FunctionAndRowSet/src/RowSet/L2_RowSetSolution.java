package RowSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class L2_RowSetSolution {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		    Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/industrial";
			String username="root";
			String password="Prince@0717";
			
			Connection con=DriverManager.getConnection(url,username,password);
			
			
			String sql="select * from employee";
			PreparedStatement ps=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString("ename");
				if(name.equals("ashish")) {   // original database affected
					rs.deleteRow();
				}
			}
			
			datafactory(rs);

	}

	private static void datafactory(ResultSet rs) throws SQLException {
		
		rs.beforeFirst();
		while(rs.next()) {
			System.out.println("method wala:--"+rs.getString("ename"));
		}
		
	}

}
