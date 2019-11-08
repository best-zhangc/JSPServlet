package com.zc.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page/hello1")
public class HelloServlet extends HttpServlet{
		/*获取需求中的name、contact两组参数值
		 * 分别使用 getParameter 和 getParameterValues  方法获取
		 */
	public void service(HttpServletRequest request  , HttpServletResponse response) throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter writer = response.getWriter();
		//获取提交name的值
		String name = request.getParameter("name");
		writer.print("<h1>Hello ,"+ name + "</h1>");
		//获取提交Contact的值
		String[] contacts = request.getParameterValues("contact");
		if (contacts!=null) {
			writer.print("<h1>联系方式:</h1>");
			for (String info : contacts) {
				writer.print("<h1>" + info + "</h1>");
			}
		}
		writer.close();
	}
}
