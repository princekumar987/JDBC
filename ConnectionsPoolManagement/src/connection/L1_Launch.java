package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class L1_Launch {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
		MysqlDataSource ds=new MysqlDataSource();
		
		ds.setUrl("jdbc:mysql://localhost:3306");
		ds.setUser("root");
		ds.setPassword("Prince@0717");
		
		//Connection con=ds.getConnection();
		
		//System.out.println(con);
		
		HikariConfig hc=new HikariConfig();
		hc.setDataSource(ds);
		
		HikariDataSource hds=new HikariDataSource(hc);
		
		//hds.setMaximumPoolSize(1000);
		
		System.out.println(hds.getMaximumPoolSize());
		
		Connection con=hds.getConnection();
		
		String sql="insert into industrial.employee(ename,ephone,esal) values (?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, "ghhy");
		ps.setString(2, "5677");
		ps.setInt(3, 678);
		
		int row=ps.executeUpdate();
		System.out.println(row);
		
		
		
		
		
		

	}

}
