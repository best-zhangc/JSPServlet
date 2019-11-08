<%@ page import="java.util.* ,java.text.SimpleDateFormat" language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <div style="font-size: 20px; border: 1px solid red ; width: 400px ; padding: 20px">
 		<% 
 			Date date = new Date();
 			SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 		%>
 		当前系统时间为 ：<%=sdf.format(date) %>
 </div>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>