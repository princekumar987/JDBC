package com.mainapp;

import java.util.ArrayList;
import java.util.Scanner;

import com.dao.Create;
import com.dao.CrudImp1;
import com.model.EmployeeModel;

public class Launch {

	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			
			
			System.out.println("p1->Insert\np2->Read\np3->Update->\np4->Delete\np5->Creation\np6->exit\nEnter Choice:--");
			
			int choice=sc.nextInt();
			sc.nextLine();
			if(choice==6) {
				System.out.println("thanks for using");
				break;
			}
			
			 CrudImp1 cimp=new CrudImp1();
			
			switch(choice) {
			     case 1:
			    	
			    	 System.out.println("Enter your name");
			    	 String name=sc.nextLine();
			    	 System.out.println("Enter your phone");
			    	 String phone=sc.next();
			    	 System.out.println("Enter your salary");
			    	 int salary=sc.nextInt();
			    	 
			    	 String insert=cimp.insert(name, phone, salary);
			    	 
			    	 if(insert.equals("saved")) {
			    		 System.out.println("data inserted");
			    	 }
			    	 else {
			    		 System.out.println("something went wrong");
			    	 }
			    	 
				     break;
				     
			     case 2:
			    	  ArrayList<Object>al=cimp.read();
			    	  
			    	  for(Object o:al) {
			    		  EmployeeModel emp=(EmployeeModel)o;
			    		  System.out.println(emp.toString());
			    	  }
				     break;
				     
			     case 3:
			    	 
			    	 System.out.println("Enter Employee ID For Updating");
			    	 int u=sc.nextInt();
			    	 System.out.println("Enter NewSalary");
			    	 int s=sc.nextInt()
;			    	 String update=cimp.update(s,u);
			    	 
			    	 if(update.equals("updated")) {
			    		 System.out.println("data updated successfully");
			    	 }
			    	 else {
			    		 System.out.println("something went wrong");
			    	 }
				     break;
				     
			     case 4:
			    	 
			    	 System.out.println("Enter Employee ID");
			    	 int d=sc.nextInt();
			    	 String delete=cimp.delete(d);
			    	 
			    	 if(delete.equals("deleted")) {
			    		 System.out.println("data deleted successfully");
			    	 }
			    	 else {
			    		 System.out.println("something went wrong");
			    	 }
				     break;
				     
			     case 5:
			    	 
			    	 Create c=new Create();
			    	 String result=c.databaseCreation();
			    	 
			    	 if(result.equals("created")) {
			    		 //table created
			    		 
			    		 System.out.println("database created successfully");
			    		 result=c.tablecreation();
			    		 if(result.equals("created")) {
			    			 System.out.println("Table created successfully");
			    		 }
			    		 else {
			    			 System.out.println("Table creation failed");
			    		 }
			    	 }
			    	 else {
			    		 System.out.println("databse already exist");
			    	 }
				     break;
				 default:
					 
					 System.out.println("Enter valid choice");
					 break;
				
			}
		}

	}

}
