package com.zc.servlet.util;

import java.sql.Connection;
import java.sql.DriverManager;



public class DBUtil {
	static String Driver ="com.mysql.jdbc.Driver" ;
	static String url = "jdbc:mysql://localhost:3306/emp?useUnicode=true&amp;characterEncoding=utf-8" ;
	static String user = "root" ;
	static String password = "1234" ;
	
	public static Connection getConnection() {
		Connection conn = null ;
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, user, password) ;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) throws Exception {
		if (conn!=null) {
			conn.close();			
		}
	}
}
