package com.zc.session.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


public class ActionServlet extends HttpServlet{
	public void service (HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
		response.setContentType("text/html ; charset = UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter() ;
		String uri = request.getRequestURI() ;
		String action = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf(".")) ;
		
		//判断动作是否登录
		if (action.equals("login")) {
			//得到用户名
			String name = request.getParameter("uname") ;
			//得到密码
			String pwd = request.getParameter("pwd");
			//得到验证码
			String number = request.getParameter("vcode");
			HttpSession session = request.getSession();
			//转换为字符串
			String code = session.getAttribute("code").toString() ;	
			//判断用户名、密码是否为 111
			if (number.equals(code) && name.equals("111") && pwd.equals("111")) {
				
				//输出session的Id
				System.out.println(session.getId());
				//设置session超时时间为 10秒
				session.setMaxInactiveInterval(10);
				session.setAttribute("uname", name);
				//重定向到首页
				response.sendRedirect("/Servlet_07day/page/index.jsp");
				//浏览器禁用Cookie时 用session的Id来传
				//response.sendRedirect(response.encodeRedirectURL("/Servlet_07day/page/index.jsp"));
			} else {
				request.setAttribute("msg", "用户名或密码错误");
				//请求转发到登录页
				request.getRequestDispatcher("/page/login.jsp").forward(request, response);
			}

		}else if(action.equals("loginout")) {
			HttpSession session = request.getSession();
			//session失效
			session.invalidate(); 
			//重定向到登录页
			response.sendRedirect("/Servlet_07day/page/login.jsp");
			
		}
		out.close();
	}
	
}
