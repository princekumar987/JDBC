package com.stored;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class L6_CreateDeleteProcedure {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="Prince@0717";
		
		Connection con=DriverManager.getConnection(url,username,password);
		
		//System.out.println(con);
		
		String sql="create Procedure storedpro.SelectData()\n"
				    +"BEGIN\n"
				    +"select * from teststoredpro.xyz;\n"
				    +"END\n";
		
		 CallableStatement cs=con.prepareCall(sql);
		 cs.execute();
		 
		 System.out.println("stored procedure created");
		 
		 sql="{call storedpro.SelectData()}";
		 cs=con.prepareCall(sql);
		 
		 ResultSet rs=cs.executeQuery();
		 
		 while(rs.next()) {
			 System.out.println(rs.getInt(1));
			 System.out.println(rs.getString(2));
		 }
		 
		 System.out.println("stored procedure called");
		 
		 
		
		   

	}

}
