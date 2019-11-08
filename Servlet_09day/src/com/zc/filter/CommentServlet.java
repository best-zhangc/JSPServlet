package com.zc.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page/comment")
public class CommentServlet extends HttpServlet{
	public void service (HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
		response.setContentType("text/html ; charset = UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter() ;
		String str = request.getParameter("comment") ;
		out.print("<h3>评论内容为："+str+"</h3>");
		out.close();
		
	}

}
