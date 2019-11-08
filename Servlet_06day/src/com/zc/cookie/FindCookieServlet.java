package com.zc.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/FindCookie")
public class FindCookieServlet  extends HttpServlet{
	public void service(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
		response.setContentType("text/html ; charset = UTF-8") ;
		PrintWriter out = response.getWriter() ;
		
		//获取Cookie 根据addcookieservlet运行后  得到cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			//(Cookie c : cookies)  ==  (c =0 , c<cookies.lenght , c++ )
			for (Cookie c : cookies) {
				String  name = c.getName() ;
				String  value = c.getValue() ;
				out.print("<h3>Name: " + name
							+ "   Value: " +URLDecoder.decode(value, "UTF-8")+"</h3>");
			}
		}else {
			out.print("没有Cookie信息！！！");
		}
	}
	

}
