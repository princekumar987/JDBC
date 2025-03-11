package com.dao;

import java.sql.Connection;
import java.sql.Statement;

public class Create {
	
	private String result;
	
	@SuppressWarnings("finally")
	public String databaseCreation () {
		

		try {
			
			Connection con=ConnectionFactory.getCon()	;
			
			String sql="create database industrial";
			Statement st=con.createStatement();
			st.execute(sql);
			
			result="created";
		}
		
		
		catch(Exception e) {
			result="failed";
			System.out.println(e);
			
		}
		finally {
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	public String tablecreation() {
		  
		try {
			
            Connection con=ConnectionFactory.getCon()	;
			
			String sql="create table industrial.employee(eid int primary key auto_increment,ename varchar(40),ephone varchar(50),esal int)";
			Statement st=con.createStatement();
			st.execute(sql);
			
			result="created";
			
		}
		catch(Exception e) {
			result="failed";
			System.out.println(e);
			
		}
		finally{
			return result;
		}
	}

}
