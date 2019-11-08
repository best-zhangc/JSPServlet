package com.zc.servlet.add;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page/add")
public class EmpServlet extends HttpServlet{
	public void service(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
		//设置中文的输入和输出
		response.setContentType("text/html ; charset = UTF-8");
		request.setCharacterEncoding("UTF-8");
		//获取输出流对象，并输出信息
		PrintWriter out = response.getWriter();
		//获取表单提交的数据
		String name = request.getParameter("name");
		Double salary = Double.valueOf(request.getParameter("salary"));
		Integer age = Integer.valueOf(request.getParameter("age"));
		out.print("<h1>员工信息</h1>");
		out.print("<h1>姓名:" + name + "</h1>");
		out.print("<h1>薪水:" + salary +"</h1>");
		out.print("<h1>年龄:" + age +"</h1>");
		out.close();
	}
}
