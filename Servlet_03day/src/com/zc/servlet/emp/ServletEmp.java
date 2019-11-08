package com.zc.servlet.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/page/ServletEmp")
public class ServletEmp extends HttpServlet{
	public void service (HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
		response.setContentType("text/html ; charset = UTF-8 ");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		Double salary = Double.valueOf(request.getParameter("salary"));
		Integer age = Integer.valueOf(request.getParameter("age"));
		System.out.println(name + "," + salary + "," + age);
		Connection conn = null ;
		PreparedStatement stat = null ; 
		try {
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/emp";
			String user="root";
			String password="1234";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			String sql = "insert into emp_test (empName,Salary,Age)  values(?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1,name);
			stat.setDouble(2, salary);
			stat.setInt(3, age);
			stat.executeUpdate();
			out.println("<h1>添加成功</h1>");
			Thread.sleep(500);
			//Thread.wait();
			//重定向
			//response.sendRedirect("/Servlet_03day/page/Emp.jsp");
			//转发
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/page/Emp.jsp");
			//dispatcher.forward(request, response);
			response.addHeader("Refresh", "6 ; url = http://localhost:8080/Servlet_03day/listEmpServlet");
			out.print("<h1>"
							+"您将在<span id='one'>6</span>秒后跳转!" + "<script type = 'text/javascript'>"
							+ "var span = document.getElementById('one') ;"
							+ "var i = 6 ;"
							+ "function fun(){"
							+ "i-- ;"
							+ "if(i >= 0){"
							+ "span.innerHTML = i ;"
							+ "}"
							+ "}"
							+ "window.setInterval(fun , 1000);"
							+ "</script>" 
							+ "</h1>");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<h1>系统繁忙，请稍后再试。。。。。</h1>");
		}finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
}
