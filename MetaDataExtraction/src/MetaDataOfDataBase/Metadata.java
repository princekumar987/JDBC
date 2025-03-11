package MetaDataOfDataBase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Metadata {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="Prince@0717";
		
		Connection con=DriverManager.getConnection(url,username,password);
		
		DatabaseMetaData d=con.getMetaData();
		
		String getUrl=d.getURL();
		System.out.println(getUrl);
		
		String getUsername=d.getUserName();
		System.out.println(getUsername);
		
		int as=d.getMaxColumnsInTable();
		System.out.println(as);
		
		int arow=d.getMaxRowSize();
		System.out.println(arow);
		
		int a=d.getDatabaseMajorVersion();
		int b=d.getDatabaseMinorVersion();
		String c=d.getDatabaseProductVersion();
		String rt=d.getDatabaseProductName();
		
		System.out.println(a+"\n"+b+"\n"+c+"\n"+rt);
		
		int a1=d.getDriverMajorVersion();
		int b1=d.getDriverMinorVersion();
		String c1=d.getDriverVersion();
		
		System.out.println(a1+"\n"+b1+"\n"+c1);
		
		
		
		
		
		
	
					
	}

}
