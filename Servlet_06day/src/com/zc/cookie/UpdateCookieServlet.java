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

@WebServlet("/UpdateCookie")
public class UpdateCookieServlet extends HttpServlet{
	public void service (HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
		response.setContentType("text/html ; charset = UTF-8"); 
		PrintWriter out = response.getWriter() ;
		Cookie[] cookies = request.getCookies() ;
		String city = URLEncoder.encode("上 海", "UTF-8") ;
		
		if (cookies != null) {
			for (Cookie c : cookies) {
				String name = c.getName() ; 
				if (name.equals("city")) {
					c.setValue(city);
					response.addCookie(c);
				}
			}			
		}
		out.close();
	}
}
