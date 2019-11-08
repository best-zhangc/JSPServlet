package com.zc.servlet.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
		String Driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/emp";
		String user = "root";
		String password = "1234";
	
	public Connection getConnect() throws Exception {
		Connection conn = null ;
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e ;
		}

		return conn;
	
	}
}
