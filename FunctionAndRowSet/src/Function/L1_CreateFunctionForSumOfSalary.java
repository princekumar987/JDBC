package Function;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class L1_CreateFunctionForSumOfSalary {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/industrial";
		String username="root";
		String password="Prince@0717";
		
		Connection con=DriverManager.getConnection(url,username,password);
		
		//System.out.println(con);
		
		String sql="CREATE FUNCTION sumOfSalary(eid_from INT, eid_to INT) "
		          + "RETURNS INTEGER "
		          + "DETERMINISTIC "  // Added this to avoid binary logging issues
		          + "BEGIN "
		          + "DECLARE sumOfSalary INTEGER; "
		          + "SELECT SUM(esal) INTO sumOfSalary FROM employee WHERE eid BETWEEN eid_from AND eid_to; "
		          + "RETURN sumOfSalary; "
		          + "END";

		
		 CallableStatement cs=con.prepareCall(sql);
		 cs.execute();
		 
		 System.out.println("function created");
		  
		
		   

	}

}
