package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.EmployeeModel;

public class CrudImp1 implements Crud {
     
	private String result;
	@SuppressWarnings("finally")
	@Override
	public String insert(String name, String phone, int salary) {
		
		try{
			
            Connection con=ConnectionFactory.getCon()	;
            String sql="insert into industrial.employee(ename,ephone,esal) values (?, ?,?)";
            
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setInt(3, salary);
            
            int row=ps.executeUpdate();
            
            if(row==1) {
            	result="saved";
            }
//            Statement st=con.createStatement();
//            
//			String sql="insert into industrial.employee(ename,ephone,esal) values ('"+name+"', '"+phone+"',"+salary+")";
//		
//			int row=st.executeUpdate(sql);
//
//			if(row==1) {
//				result="saved";
//			}
			
		
			
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
	public ArrayList<Object> read() {
		
		ArrayList<Object>al=new ArrayList<Object>();
        try{
        	
        	 Connection con=ConnectionFactory.getCon()	;
        	 String sql="select * from industrial.employee ";
        	 
        	 PreparedStatement ps=con.prepareStatement(sql);
        	 
        	 ResultSet rs=ps.executeQuery();
        	 
        	 
        	 while(rs.next()) {
        		 
        		 int getEid=rs.getInt("eid");
        		 String getEname=rs.getString("ename");
        		 String getEphone=rs.getString("ephone");
        		 int getEsalary=rs.getInt("esal");
        		 
        		 EmployeeModel emp= new EmployeeModel(getEid,getEname,getEphone,getEsalary);
        		 
        		 al.add(emp);
        		 
        	 }
        	 
        	 
        	 
//             Statement st=con.createStatement();
//             
// 			 String sql="select * from industrial.employee where ephone="+phone;
// 			 
// 			
// 			 ResultSet rs= st.executeQuery(sql);
// 			 

 			 
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
		   return al;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public String delete(int eid) {
		
        try{
        	
        	 Connection con=ConnectionFactory.getCon()	;
        	 String sql="delete from industrial.employee where eid=?";
        	 PreparedStatement ps=con.prepareStatement(sql);
        	 
        	 ps.setInt(1, eid);
        	 
        	 int row=ps.executeUpdate();
        	 
        	 if(row==1) {
        		 result="deletd";
        	 }
   	 
        	 
        	 
        	 
//             Statement st=con.createStatement();
//             
// 			 String sql="delete from industrial.employee where eid="+eid;
// 			 
// 			
// 			 int row=st.executeUpdate(sql);
// 			 
// 			 if(row==1) {
// 				 result="deleted";
// 			 }
        	
			
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
        	  String sql = "UPDATE industrial.employee SET esal=? WHERE eid=?";
        	  
        	  PreparedStatement ps=con.prepareStatement(sql);
        	  
        	  ps.setInt(1, esal);
        	  ps.setInt(2, eid);
        	  
        	  int row=ps.executeUpdate();
        	  
        	  if(row==1) {
        		  result="upadated";
        	  }
        	 
        	  
        	  
//              Statement st=con.createStatement();
//            
//              String sql = "UPDATE industrial.employee SET esal="+esal+" WHERE eid="+eid;
//
//			 
//			
//			  int row=st.executeUpdate(sql);
//			  System.out.println(row);
//			 
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
