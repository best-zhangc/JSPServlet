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
@WebServlet("/delete")
public class DeleteEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
		response.setContentType("text/html ; charset = UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int empId = Integer.parseInt(request.getParameter("id"));
		Connection conn = null;
		try {
			conn = new DBUtil().getConnect();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "delete from emp_test where empId = ?";
		System.out.println(sql);
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, empId);
			stat.executeUpdate();
			response.sendRedirect("listEmpServlet");
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("Error");
		}finally {
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
