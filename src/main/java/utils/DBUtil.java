package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static final String JDBC_URL="jdbc:mysql://localhost:3306/blog_system";
	private static final String JDBC_USER="root";
	private static final String JDBC_PASS="1234";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
	}
	
	
	

}
