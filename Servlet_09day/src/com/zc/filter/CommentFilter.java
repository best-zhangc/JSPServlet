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

public class CommentFilter implements Filter{
	private String illegalWord; 
	
	/**
	 * 容器删除过滤器实列之前调用 ， 只执行一次
	 */
	@Override
	public void destroy() {
		
	}

	/**
	 * 用于处理请求的主要方法
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request ;
		HttpServletResponse resp = (HttpServletResponse) response ; 
		resp.setContentType("text/html ; charset = UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter() ;
		String comment = req.getParameter("comment") ;
		if (comment.indexOf(illegalWord) != -1) {
			//有敏感词汇
			out.print("<h3>评论内容已关闭</h3>");
			
		} else {
			//没有敏感词汇则向后处理 ， 交给其他过滤器或Servlet
			chain.doFilter(req, resp);
		}
	}

	/**
	 * 启动容器后创建过滤器实列
	 * 然后调用init方法 ， 只会调用一次
	 * 容器将已经创建好的FilterConfig对象作为参数传入
	 * 可以从该参数中获取初始化配置信息
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		illegalWord = filterConfig.getInitParameter("illegalWord") ;
		System.out.println("Filter1:init is runnming..." + illegalWord);
		
	}

}
