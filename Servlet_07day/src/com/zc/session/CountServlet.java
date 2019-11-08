package com.zc.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet{
	public void service(HttpServletRequest request , HttpServletResponse response) throws ServletException ,IOException{
		response.setContentType("text/html ; charset = UTF-8"); 
		PrintWriter out = response.getWriter() ;
		//获取Session对象
		HttpSession session = request.getSession() ;
		//输出Session
		System.out.println(session.getId());
		Integer count = (Integer) session.getAttribute("count	") ;
		if (count==null) { //第一次访问
			count =1 ;
			
		} else {//不是第一次访问
			count ++ ;
		}
		//在session中绑定计数器
		session.setAttribute("count	",	count);
		//输出提示信息
		out.print("这是第" +count+"次访问");
		out.close();
		
	}

}
