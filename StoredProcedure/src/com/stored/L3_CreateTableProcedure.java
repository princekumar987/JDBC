package com.stored;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class L3_CreateTableProcedure {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="Prince@0717";
		
		Connection con=DriverManager.getConnection(url,username,password);
		
		//System.out.println(con);
		
		String sql="create Procedure storedpro.createMyTable(IN tbName varchar(30))\n"
				    +"BEGIN\n"
				    +"SET @createTbname=CONCAT('create table teststoredpro.',tbName,'(eid int primary key, ename varchar(30))');\n"
				    +"PREPARE createTbst from @createTbname;\n"
				    +"EXECUTE  createTbst;\n"
				    +"END";
		
		 CallableStatement cs=con.prepareCall(sql);
		 cs.execute();
		 
		 System.out.println("stored procedure created");
		 
		 sql="{call storedpro.createMyTable(?)}";
		 cs=con.prepareCall(sql);
		 cs.setString(1, "abcde");
		 cs.execute();
		 
		 System.out.println("stored procedure called");
		 
		 
		
		   

	}

}
