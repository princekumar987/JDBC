package com.stored;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class L2_CreateDataBaseProcedureByDynamic {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="Prince@0717";
		
		Connection con=DriverManager.getConnection(url,username,password);
		
		//System.out.println(con);
		
		String sql="create Procedure storedpro.createMyDatabase(IN dbName varchar(30))\n"
				    +"BEGIN\n"
				    +"SET @createdbSql= CONCAT('create database ',dbName);\n"
				    +"PREPARE createDBst from @createdbSql;\n"
				    +"EXECUTE createDBst;\n"
				    +"END\n";
		
		 CallableStatement cs=con.prepareCall(sql);
		 cs.execute();
		 
		 System.out.println("stored procedure created");
		 
		 sql="{call storedpro.createMydatabase(?)}";
		  cs=con.prepareCall(sql);
		 cs.setString(1,"pogo");
		 cs.execute();
		 
		 System.out.println("stored procedure called");
		 
		 
		
		   

	}

}
