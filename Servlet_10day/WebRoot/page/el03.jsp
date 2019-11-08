<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	获取请求参数<hr/>
	姓名:${param.name}<br><hr/>
	爱好:${paramValues.interest[0]}<br>
	爱好:${paramValues.interest[1]}<br>
	<hr/>
	<h5>http://localhost:8080/Servlet_10day/page/el03.jsp?name=Luffy&interest=Sleeping&interest=Eating</h5>
</body>
</html>