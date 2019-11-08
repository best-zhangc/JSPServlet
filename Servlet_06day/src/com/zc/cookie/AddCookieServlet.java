package com.zc.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCookie")
public class AddCookieServlet extends HttpServlet{

	public void service(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
		response.setContentType("text/html ; charset = UTF-8") ;
		PrintWriter out = response.getWriter() ;
		//转换中文
		String city = URLEncoder.encode("北京" , "UTF-8");
		//创建cookie
		Cookie c1 = new Cookie("uname", "kitty") ;
		Cookie c2 = new Cookie("city",city) ;
		
		//添加cookie到response中
		response.addCookie(c1);
		response.addCookie(c2);
		
		out.close();
	}
}
