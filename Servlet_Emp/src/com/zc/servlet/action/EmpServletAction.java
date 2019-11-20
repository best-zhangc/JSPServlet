package com.zc.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zc.servlet.bean.Employee;
import com.zc.servlet.dao.EmployeeDao;

@WebServlet(urlPatterns = {"/page/list.do" , "/page/addEmp.do" , "/page/delete.do" , 
											"/page/update.do" , "/page/modify.do"})
public class EmpServletAction extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{
		response.setContentType("text/html;charset = UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI() ;
		String action = uri.substring(uri.lastIndexOf("/") , uri.lastIndexOf(".")) ;
		/*查询全部*/
		if ("/list".equals(action)) {
			EmployeeDao empDao = new EmployeeDao() ;
			List<Employee> emps = null ;
			try {
				emps = empDao.findAll() ;
				request.setAttribute("emps", emps);
				request.getRequestDispatcher("/page/list.jsp").forward(request, response);
			} catch (Exception e) {
				out.print("<h1>System busy please try again!</h1>");
				e.printStackTrace();
			}	
		}
		/*添加*/
		else if ("/addEmp".equals(action)) {
			String name = request.getParameter("name");
			Double  salary = Double.valueOf(request.getParameter("salary"));
			Integer age = Integer.valueOf(request.getParameter("age")) ;
			Employee emp = new Employee() ;
			emp.setEmpName(name);
			emp.setSalary(salary);
			emp.setAge(age);
			/*System.out.println(emp.toString());*/
			EmployeeDao empdao = new EmployeeDao() ;
			try {
				empdao.save(emp);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				out.print("<h1>System busy please try again!<h1>");
				e.printStackTrace();
			}
		}
		/*根据id删除*/
		else if ("/delete".equals(action)) {
			int empId = Integer.parseInt(request.getParameter("empId")) ;
			Employee emp = new Employee() ;
			emp.getEmpId();
			System.out.println(emp.getEmpId());
			EmployeeDao empDao = new EmployeeDao() ;
			try {
				empDao.delete(empId);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				out.print("<h1>System busy please try again!<h1>");
				e.printStackTrace();
			}
		}
		/*根据id查询跳转modify*/
		else if ("/update".equals(action)) {
			int empId = Integer.parseInt(request.getParameter("empId"));
			EmployeeDao empDao = new EmployeeDao();
			Employee emp ;
			try {
				emp = empDao.findById(empId) ;
				request.setAttribute("emp", emp);
				request.getRequestDispatcher("/page/modify.jsp").forward(request, response);//转发到modify.jsp
			} catch (Exception e) {
				out.print("<h1>System Busy Please Try Again!</h1>");
				e.printStackTrace();
			}
		}
		/*修改*/
		else if ("/modify".equals(action)) {			
			EmployeeDao empDao = new EmployeeDao();
			Employee emp = new Employee();
			int empId = Integer.parseInt(request.getParameter("empId")) ;
			String empName = request.getParameter("empName") ;
			Double salary = Double.parseDouble(request.getParameter("salary")) ;			
			Integer age = Integer.valueOf(request.getParameter("age")) ;
			emp.setEmpId(empId);
			emp.setEmpName(empName);
			emp.setSalary(salary);
			emp.setAge(age);
/*			System.out.println(request.getParameter("saraly"));
*/			try {
				empDao.update(emp);
				response.sendRedirect("list.do");//重定向到list.jsp
			} catch (Exception e) {
				request.setAttribute("error", "修改页面出错 ，请重试");
				request.getRequestDispatcher("/page/error.jsp").forward(request, response);
				e.printStackTrace();
			}
		}
	}
	
}
