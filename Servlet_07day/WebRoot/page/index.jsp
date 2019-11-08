<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Object uname = session.getAttribute("uname") ;
    	if(uname == null){
    		response.sendRedirect("/Servlet_07day/page/login.jsp");
    		return;
    	}
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>首页</h3> 欢迎您：<%=uname.toString() %> <br><br><br><br>
	
	<a href="/Servlet_07day/page/login.jsp">登出</a>
</body>
</html>