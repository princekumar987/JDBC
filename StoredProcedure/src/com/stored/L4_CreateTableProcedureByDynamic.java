package com.stored;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class L4_CreateTableProcedureByDynamic {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="Prince@0717";
		
		Connection con=DriverManager.getConnection(url,username,password);
		
		//System.out.println(con);
		
		String sql="create Procedure storedpro.createMyTable()\n"
				    +"BEGIN\n"
				    +"create table  teststoredpro.xyz(eid int primary key, ename varchar(40));\n"
				    +"END\n";
		
		 CallableStatement cs=con.prepareCall(sql);
		 cs.execute();
		 
		 System.out.println("stored procedure created");
		 
		 sql="{call storedpro.createMyTable()}";
		 cs=con.prepareCall(sql);
		 cs.execute();
		 
		 System.out.println("stored procedure called");
		 
		 
		
		   

	}

}
