package com.stored;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class L5_CreateInsertProcedure {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="Prince@0717";
		
		Connection con=DriverManager.getConnection(url,username,password);
		
		//System.out.println(con);
		
		String sql="create Procedure storedpro.InsertData(IN geteid int ,IN getename varchar(30))\n"
				    +"BEGIN\n"
				    +"insert into teststoredpro.xyz(eid,ename) values (geteid,getename);\n"
				    +"END\n";
		
		 CallableStatement cs=con.prepareCall(sql);
		 cs.execute();
		 
		 System.out.println("stored procedure created");
		 
		 sql="{call storedpro.InsertData(?,?)}";
		 cs=con.prepareCall(sql);
		 cs.setInt(1,14 );
		 cs.setString(2,"jaju");
		 cs.execute();
		 
		 System.out.println("stored procedure called");
		 
		 
		
		   

	}

}
