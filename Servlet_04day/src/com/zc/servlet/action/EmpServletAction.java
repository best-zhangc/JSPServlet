package com.zc.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zc.servlet.bean.Employee;
import com.zc.servlet.dao.EmployeeDao;

public class EmpServletAction extends HttpServlet{
	public void service (HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
		response.setContentType("text/html ; charset = UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1	, uri.lastIndexOf("."));
		if (action.equals("list")) {
			try {
				EmployeeDao dao = new EmployeeDao();
			
			List<Employee> emps = dao.findAll();
			out.println("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"60%\">"
			 		+ "<caption>员工信息列表</caption>"
			 		+ "<tr>"
			 		+ "<td>ID</td>"
			 		+ "<td>姓名</td>"
			 		+ "<td>薪水</td>"
			 		+ "<td>年龄</td>"
			 		+ "<td>操作</td>"
			 		+ "</tr>");
			for (Employee emp : emps) {
				out.println("<tr>"
						+ "<td>"+ emp.getEmpId()+"</td>"
						+ "<td>"+ emp.getEmpName()+"</td>"
						+ "<td>"+ emp.getSalary()+"</td>"
						+ "<td>"+ emp.getAge()+"</td>"
						+ "<td><a href = 'delete.do?id="+emp.getEmpId()+"' onclick = \"return confirm('是否确定删除  "+emp.getEmpName()+"');\">删除</a>&emsp; &emsp;"
						+ "<a href = '#'>修改</a></td>"
						+ "</tr>");
			}
			out.println("</table>");
			out.println("<a href = '/Servlet_04day/page/addEmp.jsp'>增加员工</a>");
			} catch (Exception e) {
				e.printStackTrace();
				out.println("系统繁忙，请稍后再试！");
			}
		}
		else if (action.equals("add")) {
			String name = request.getParameter("name");
			double salary = Double.parseDouble(request.getParameter("salary"));
			int age = Integer.parseInt(request.getParameter("age"));
			try {
			Employee emp = new Employee();
			emp.setEmpName(name);
			emp.setSalary(salary);
			emp.setAge(age);
			EmployeeDao dao = new EmployeeDao();
				dao.add(emp);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				out.print("系统繁忙！");
			}	
		}
		else if (action.equals("delete")) {
			int empId = Integer.parseInt(request.getParameter("id"));
			Employee emp = new Employee() ;
			emp.getEmpId();
			out.println(emp.getEmpId());
			try {
			EmployeeDao dao = new EmployeeDao();
				dao.delete(empId);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				out.print("系统错误！！");
			}
			
		}
		
	}

}
