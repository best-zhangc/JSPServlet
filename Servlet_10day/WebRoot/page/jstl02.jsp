<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.zc.employee.bean.Employee"%>
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
	<%
	Employee emp1 = new Employee();
	emp1.setName("Luffy");
	emp1.setGender("m");
	/* 绑定对象 */
	request.setAttribute("emp1", emp1);
	
	Employee emp2 = new Employee();
	emp2.setName("Zoro");
	emp2.setGender("m");
	request.setAttribute("emp2", emp2);
	
	List<Employee> emps  =  new ArrayList<Employee>();
	emps.add(emp1);
	emps.add(emp2);
	request.setAttribute("emps", emps);
	
	%>
	
forEach标签1: <hr/>
	<c:forEach var="emp" items="${emps}">
		姓名:${emp.name}<br>
		 
		性别:${emp.gender}<br><br>
	</c:forEach><br>
forEach标签2: <hr/>	
	<c:forEach var="emp" items="${emps}" varStatus="s">
	<p class="s${s.index%2+1}">
		姓名:${emp.name}<br>
		性别:${emp.gender}<br>
		index:${s.index}<br>
		count:${s.count}<br><br>
<!--index集合下标 ， count访问过对象个数 -->
	</c:forEach>

</body>
</html>