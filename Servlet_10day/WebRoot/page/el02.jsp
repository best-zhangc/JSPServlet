<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--使用EL表达式进行运算  -->
1.算术运算<hr/>
	加: ${1+2}<br><br>
	加: ${"123" + "456"}<br>
	<h4>加号只能进行加法运算不能连接</h4>
	<hr/><br>
2.关系运算<hr/>
	${"123" == "123" }<br>
	${"123" eq "123" }<br>
	<%pageContext.setAttribute("str", "abc"); %>
	${"str" eq "abc" }<br><hr/>
	
3.empty运算<hr/>
	<%
	request.setAttribute("str1", "");
	List list = new ArrayList();
	request.setAttribute("list1", list);
	request.setAttribute("obj", null);		
	%>
	空字符串:  ${empty str1} <br>
	找不到绑定名对象: ${empty xxx} <br>
	集合类容为空: ${empty list1} <br>
	null结果: ${empty obj}<br><hr/>
</body>
</html>