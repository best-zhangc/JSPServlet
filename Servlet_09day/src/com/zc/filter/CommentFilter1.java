package com.zc.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter1 implements Filter{
	private int length ;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request ;		
		HttpServletResponse resp = (HttpServletResponse) response ;
		resp.setContentType("text/html ; charset = UTF-8"); 
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter() ;
		String str = req.getParameter("comment") ;
		if (str.length() > length) {
			out.print("<h3>评论内容太长 ，请重新输入");
			
		} else {
			chain.doFilter(request	, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		length = Integer.parseInt(filterConfig.getInitParameter("illegalLength")) ;
		System.out.println("Filter1:init is runnming..." + length);
	}

}
