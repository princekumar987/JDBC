package Function;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class L2_CreateforcalingrSumOfSalary2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/industrial";
		String username="root";
		String password="Prince@0717";
		
		Connection con=DriverManager.getConnection(url,username,password);
		
		//System.out.println(con);
		
		String sql="{?=call sumOfSalary(?,?)}";
		
		CallableStatement cs=con.prepareCall(sql);
		
		cs.registerOutParameter(1, Types.INTEGER);
		
		cs.setInt(2, 10);
		cs.setInt(3, 13);
		
		cs.execute();
		
		int sum_Of_Salary=cs.getInt(1);
		System.out.println(sum_Of_Salary);
		  
		
		   

	}

}
