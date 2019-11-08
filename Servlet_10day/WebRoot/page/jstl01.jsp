<%@page import="com.zc.employee.bean.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Employee emp = new Employee();
	emp.setName("Luffy");
	emp.setGender("m");
	/* 绑定对象 */
	request.setAttribute("emp", emp);
	
	%>
	
1.if标签：<hr/>
	员工姓名:${emp.name} <br><br>
	员工性别:<c:if test="${emp.gender=='m'}" var="rs" scope="request">男</c:if>
				<c:if test="${!rs}">女</c:if>
	<!-- rs:记录test结果的临时变量 --><br><br>
2.choose标签:<hr/>
	员工性别：
	<c:choose>
		<c:when test="${emp.gender =='m'}">男</c:when>
		<c:otherwise>女</c:otherwise>
	</c:choose>	
	
</body>
</html>