package RowSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class L1_ResultSetProblems {

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
			
			
			CachedRowSet crs=RowSetProvider.newFactory().createCachedRowSet();
			crs.populate(rs);
			con.close();
			
			while(crs.next()) {
				String name=crs.getString("ename");
				if(name.equals("akash")) {   // original database affected
					crs.deleteRow();
				}
			}
			
			datafactory(crs);

	}

	private static void datafactory(CachedRowSet crs) throws SQLException {
		
		crs.beforeFirst();
		while(crs.next()) {
			System.out.println("method wala:--"+crs.getString("ename"));
		}
		
	}

}
