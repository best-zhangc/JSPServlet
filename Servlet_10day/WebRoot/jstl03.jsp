<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.s1{ color:red;}
	.s2{ color:purple;}
</style>
</head>
<body>
员工信息列表:<hr/>
	<c:forEach var="emp" items="${emps}" varStatus="s">
	<p class="s${s.index%2+1}">
		姓名:${emp.name}<br>
		性别:
		<c:choose>
			<c:when test="${emp.gender=='m'}">男</c:when>
			<c:when test="${emp.gender=='f'}">女</c:when>
			<c:otherwise>未知</c:otherwise>
		</c:choose><br>
	</p>
	</c:forEach>

</body>
</html>