package com.zc.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet")
public class RequestInfo extends HttpServlet{
	public void service(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
		//获取所有消息头的名称
		Enumeration  e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			//遍历Enumeration获取每一个消息的头名称
			String hederName = e.nextElement().toString();
			//输出消息头的名-值对信息
			System.out.println(hederName + ":" + request.getHeader(hederName));	
		}
		System.out.println("请求方式：" + request.getMethod());
		System.out.println("请求的协议种类：" + request.getProtocol());
		System.out.println("请求资源路径：" + request.getRequestURI());
		System.out.println("请求的路径信息：" + request.getRequestURL());
		System.out.println("请求的Servlet路径：" + request.getServletPath());
	}
}
