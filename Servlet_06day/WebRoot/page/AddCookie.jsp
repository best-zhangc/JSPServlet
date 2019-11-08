<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%
   		Cookie c1 = new Cookie("uname" , "kitty");
	   //设置路径为应用根路径
	   c1.setPath("/Servlet_06day");
	   response.addCookie(c1);
   %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Cookie操作</p>
</body>
</html>