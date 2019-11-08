package com.zc.servlet.add;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listEmpServlet")
public class ListEmpServlet extends HttpServlet{
	public void service (HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset = UTF-8");
		PrintWriter out = response.getWriter();
		Connection conn =null ;
		PreparedStatement stat = null ;
		ResultSet rs = null ;
		String Driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/emp";
		String user = "root";
		String password = "1234";
		try {
			Class.forName(Driver);
			 conn = DriverManager.getConnection(url, user, password);
			String sql = "select * from emp_test";
			stat = conn.prepareStatement(sql);
			 rs = stat.executeQuery();
			 out.println("<html><head>"
			 		+ "<meta http-equiv=\"content-type\"  content=\"text/html ; charset = UTF-8\" >"
			 		+ "<title>ServletTest_03</title>"
			 		+ "</head><body>"
			 		+ "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"60%\">"
			 		+ "<caption>员工信息列表</caption>"
			 		+ "<tr>"
			 		+ "<td>ID</td>"
			 		+ "<td>姓名</td>"
			 		+ "<td>薪水</td>"
			 		+ "<td>年龄</td>"
			 		+ "<td>操作</td>"
			 		+ "</tr>");
			while (rs.next()) {
				int id = rs.getInt("empId");
				String name = rs.getString("empName");
				double salary = rs.getDouble("salary");
				int age = rs.getInt("age");
				/*out.println("<tr><td>" 
						+ id + "</td><td>"
						+ name+ "</td><td>"
						+ salary + "</td><td>"
						+ age + "</td><td>"
								+ "</td></tr>");*/
				out.println("<tr>");
				out.println("<td>"+ id + "</td>");
				out.println("<td>"+ name + "</td>");
				out.println("<td>"+ salary + "</td>");
				out.println("<td>"+ age + "</td>");
				// 【\】为转译符
				out.println("<td><a href = ' delete?id="+id+" ' onclick = \"return confirm('是否确定删除 "+name+" ');\">删除</a>");
				out.println("<a href = ' load?id="+id+" '>修改</a></td>");
				out.println("</tr>");
			}
		out.println("</table>");
		out.println("<a href = '/Servlet_03day/page/Emp.jsp'>增加员工信息</a>");
		out.println("</body></html>");
		
		out.flush();
		out.close();
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙 请稍后再试。。。。");
		}finally{
			
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
	}
}
