package com.zc.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page/hello2")
public class HelloServlet01 extends HttpServlet{
	public void service (HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
		//保证正确输入中文
		resp.setContentType("text/html ; charset = UTF-8"); 
		PrintWriter out = resp.getWriter();
		//获取提交的name值
		String name = req.getParameter("name");
		//保证正确读取get提交来的中文
		name = new String(name.getBytes("iso-8859-1") , "UTF-8");
		out.print("<h1>Hello ,"+ name + "</h1>");
		//获取提交Contact的值
		String[] contacts = req.getParameterValues("contact");
		if (contacts!=null) {
			out.print("<h1>联系方式:</h1>");
			for (String contact : contacts) {
				out.print("<h1>" + contact + "</h1>");
			}
		}
		out.close();
	}
	
}
