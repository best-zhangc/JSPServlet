package com.zc.servlet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static String Driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/emp";
	static String user = "root";
	static String password = "1234";
	
	/*String Driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/emp";
	String user = "root";
	String password = "1234";*/
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(Driver);
			 conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;	
	}
	
	public static void close(Connection conn) throws Exception {
		if (conn != null) {
			conn.close();
			
		}
	}
}
