package Batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

public class L1_Launch {

	public static void main(String[] args) {


		try {
			
			Scanner sc=new Scanner(System.in);
			Connection con=ConnectionFactory.getCon();
			
			String sql="insert into industrial.employee(ename,ephone,esal) values (?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			while(true) {
				
				System.out.println("Eneter name");
				String name=sc.next();
				
				System.out.println("Eneter phone");
				String phone=sc.next();
				
				System.out.println("Eneter salary");
				int sal=sc.nextInt();
				
				String result=new Validation().validate(name,phone,sal);
				
				if(result.equals("valid")) {
					ps.setString(1, name);
					ps.setString(2, phone);
					ps.setInt(3, sal);
					ps.addBatch();
				}
				else {
					System.out.println("insertion failed due to validation:--"+result);
				}
				
				
				System.out.println("Press * to continue");
				char ch=sc.next().charAt(0);
				if(ch!='*')break;
				
			}
			
			int []k=ps.executeBatch();
			
			for(int row:k) {
				System.out.println(row);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
