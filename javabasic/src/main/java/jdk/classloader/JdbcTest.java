package jdk.classloader;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest {

	
	public static void main(String[] args) throws Exception {
		
		System.out.println(System.getProperty("jdbc.drivers"));
		
		DriverManager.setLogWriter(new PrintWriter(System.out, true));
		Class.forName("com.mysql.jdbc.Driver");
		//DriverManager.setLogWriter(new PrintWriter(new FileOutputStream("/tmp/driverManager.log"), true));
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/test", 
				"admin",
				"123456");
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from daily_hit_counter");
		while(rs.next()) {
			System.out.println(rs.getDate(1));
			System.out.println(rs.getInt(2));
			System.out.println(rs.getInt(3));
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
