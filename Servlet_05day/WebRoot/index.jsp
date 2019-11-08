<%@ page language = "java" contentType = "text/html ; charset = UTF_8"
pageEncoding = "UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body style="font-size: 24px">
<!--  使用 out.print ("HELLO JSP"); 方式输出 -->
	<%
		for (int i = 0 ; i < 10 ; i++) {
			out.print("使用print输出：" + "HELLO JSP <br>");
		}
	%>
	<hr>

	<!-- 使用<%-- <%= HELLO JSP%>  --%>方式输出 -->
	<%
		for (int i = 0 ; i < 10 ; i++) {
	%>
		<%="使用<%=....>方式输出：" + "NO." + (i+1) + "HELLO JSP" %> <br>
		
	<%
		}
	%>
</body>
</html>