package com.zc.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/PersistentCookie")
public class PersistentCookieServlet extends HttpServlet{
	public void service(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
		response.setContentType("text/html ; charset = UTF-8"); 
		PrintWriter out = response.getWriter() ;
		//创建Cookie 
		Cookie c1 = new Cookie("uname", "kitty") ;
		//设置c1的过期时间
		c1.setMaxAge(100) ;
		response.addCookie(c1);
		Cookie c2 = new Cookie("value", "beijing") ;
		response.addCookie(c2);
		out.close();

	}

}
