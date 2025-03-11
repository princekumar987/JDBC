package MetaDataOfTable;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Metadata {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
    
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="Prince@0717";
		
		Connection con=DriverManager.getConnection(url,username,password);
		
	    String sql="select * from industrial.employee";
	    PreparedStatement ps=con.prepareStatement(sql);
	    
	    ResultSetMetaData rm=ps.getMetaData();
	    
	    int ccount=rm.getColumnCount();
	    System.out.println(ccount);
	    
	    for(int i=1;i<=ccount;i++) {
	    	String cname=rm.getColumnName(i);
		    System.out.println(cname);
	    }
	    
	    for(int i=1;i<=ccount;i++) {
	    	String cname=rm.getColumnClassName(i);
		    System.out.println(cname);
	    }
	    
	    for(int i=1;i<=ccount;i++) {
	    	int cname=rm.getColumnDisplaySize(i);
		    System.out.println(cname);
	    }
	    
	    String catalogName=rm.getCatalogName(1);
	    System.out.println(catalogName);
	    
	    
	    
	    
		
		
	}

}
