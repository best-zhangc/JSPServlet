<%@ page language="java" 
		import="java.util.* , java.text.SimpleDateFormat"
		contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	    
	 <div>
	 	<%
	 Date  date=	new Date();
	 SimpleDateFormat spdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	%>
	 	当前系统时间为：<%=spdf.format(date) %>
	 </div>