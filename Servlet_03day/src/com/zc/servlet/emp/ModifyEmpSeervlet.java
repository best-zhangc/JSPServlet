package com.zc.servlet.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zc.servlet.util.DBUtil;

@WebServlet("/modify")
public class ModifyEmpSeervlet extends HttpServlet {
	public void service(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset = UTF-8 ");
		PrintWriter out = response.getWriter();
		int empId = Integer.parseInt(request.getParameter("empId"));
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));
		Connection conn = null;
		try {
			conn = new DBUtil().getConnect();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement stat =null;
		String sql = "update  emp_test  set  empName = ? , Salary = ? , Age = ? where empId = ?";
		try {
		    stat = conn.prepareStatement(sql);
			stat.setString(1, name);
			stat.setDouble(2, salary);
			stat.setInt(3, age);
			stat.setInt(4, empId);
			stat.executeUpdate();
			response.sendRedirect("listEmpServlet");
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("系统异常 请稍后再试 "
					+ "<br>"
					+ "<p>"
					+ "<a href='listEmpServlet'>员工信息列表</a>"
					+ "</p>");
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
