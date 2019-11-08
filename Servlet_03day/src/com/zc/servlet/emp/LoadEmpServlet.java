package com.zc.servlet.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zc.servlet.util.DBUtil;

@WebServlet("/load")
public class LoadEmpServlet extends HttpServlet {
	public void service(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
		//设置中文的输入和输出
		response.setContentType("text/html ; charset = UTF-8");
		request.setCharacterEncoding("UTF-8");
		//获取输出流对象 输出信息
		PrintWriter out = response.getWriter();
		//获取请求参数值
		int empId = Integer.parseInt(request.getParameter("id"));
		//数据库连接 根据id查询数据库获取员工信息
		Connection conn = null;
		try {
			conn = new DBUtil().getConnect();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "select * from emp_test where empId = ?";
		ResultSet rs = null;
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, empId);
			rs = stat.executeQuery();
			out.println("<html><head>"
							+ "<meta http-equiv=\"content-type\" content=\"text/html ; charset = UTF-8\"> "
							+ "<title>ServletTest_03</title>"
							+ "</head>"
							+ "<body style=\"font-size: 20px\">");
			if (rs.next()) {
				String name = rs.getString("empName");
				double salary = rs.getDouble("Salary");
				int age = rs.getInt("Age");
				out.println("<form action = 'modify' method = 'post'>");
				out.println("编号:"+ empId + "<br>");
				out.println("<input type = 'hidden' name = 'empId' value = '"+ empId +"'/> <br>");
				out.println("姓名:<input name = 'name' value = '"+ name +"'/> <br>");
				out.println("薪水:<input name = 'salary' value = '"+ salary +"'/> <br>");
				out.println("年龄:<input name = 'age' value = '"+ age +"'/> <br>");
				out.println("<input type = 'submit'  value = '修改'/> <br>");
				out.println("</form>");
			}
			
			out.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统异常 请稍后再试");
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
