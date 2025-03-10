package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CrudImp1 implements Crud {
     
	private String result;
	@SuppressWarnings("finally")
	@Override
	public String insert(String name, String phone, int salary) {
		
		try{
			
            Connection con=ConnectionFactory.getCon()	;
            Statement st=con.createStatement();
            
			String sql="insert into industrial.employee(ename,ephone,esal) values ('"+name+"', '"+phone+"',"+salary+")";
		
			int row=st.executeUpdate(sql);

			if(row==1) {
				result="saved";
			}
			
		
			
		}
		catch(Exception e) {
			
			result="faild";
			System.out.println(e);
		}
		finally {
		   return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public String read(String phone) {
		
        try{
        	
        	 Connection con=ConnectionFactory.getCon()	;
             Statement st=con.createStatement();
             
 			 String sql="select * from industrial.employee where ephone="+phone;
 			 
 			
 			 ResultSet rs= st.executeQuery(sql);
 			 
 			 
// 			 int jh=1;
// 			 while(rs.next()) {
// 				 
// 				 System.out.println("***Employee--->"+jh+"***");
// 				 System.out.println("EID="+rs.getInt("eid"));
// 				 System.out.println("ENAME="+rs.getString("ename"));
// 				 System.out.println("EPHONE="+rs.getString("ephone"));
// 				 System.out.println("ESALARY="+rs.getInt("esal"));
// 				 jh++;
// 				 System.out.println();
// 			 }
 			 
 			 rs.next();
 			 System.out.println("Emplyee Detials is-----");
 			 
			 System.out.println("EID="+rs.getInt("eid"));
			 System.out.println("ENAME="+rs.getString("ename"));
			 System.out.println("EPHONE="+rs.getString("ephone"));
			 System.out.println("ESALARY="+rs.getInt("esal"));
 			 
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
		   return null;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public String delete(int eid) {
		
        try{
        	
        	 Connection con=ConnectionFactory.getCon()	;
             Statement st=con.createStatement();
             
 			 String sql="delete from industrial.employee where eid="+eid;
 			 
 			
 			 int row=st.executeUpdate(sql);
 			 
 			 if(row==1) {
 				 result="deleted";
 			 }
        	
			
		}
		catch(Exception e) {
			result="failed";
			System.out.println(e);
		}
		finally {
			
			return result;
		   //return null;
		} 
	}

	@SuppressWarnings("finally")
	@Override
	public String update(int esal, int eid) {
		
        try{
        	
        	  Connection con=ConnectionFactory.getCon()	;
              Statement st=con.createStatement();
            
              String sql = "UPDATE industrial.employee SET esal="+esal+" WHERE eid="+eid;

			 
			
			  int row=st.executeUpdate(sql);
			  System.out.println(row);
			 
			   if(row==1) {
				 result="updated";
			
		       }
        }
		catch(Exception e) {
			result="failed";
			System.out.println(e);
		}
		finally {
		   return result;
		}
	}

}
