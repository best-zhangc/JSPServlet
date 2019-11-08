<%@page import="com.zc.user.bean.User"%>
<%@page import="com.zc.course.bean.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
		Course course = new Course();
		course.setCourseId(1);
		course.setCourseName("Servlet");
		User u1 = new User();
		u1.setUserName("Luffy");
		u1.setAge(17);
		u1.setCourse(course);
		u1.setInterest(new String []{"sleeping" , "Eating"});
		request.setAttribute("user"	, u1);
		
	%>
	<!-- 1.java代码 -->
1.java代码<hr/>
	<%
		User u = (User)request.getAttribute("user");
		out.println(u.getUserName());	
		out.println(u.getAge());
		
	%><br><br>
	
	<!--2.el表达式 1 -->
2.el表达式1<hr/>
	
	<!-- 2.1常用类型 -->
	
	 姓名:${user.userName}<br>
	年龄:${user.age}<br>
	
	<!-- 2.2 引用类型 -->
	课程:${user.course.courseName}<br> <br>
	
	<!--3.el表达式2  -->
3.el表达式2<hr/>
	姓名:${user ["userName"]}<br>
	<%
		request.setAttribute("userAge","age");
	%>
	年龄:${user [userAge]}<br>
	爱好:${user.interest[1]}<br><br>
	
 4.访问范围<hr/>
	姓名:${requestScope.user.userName}

</body>
</html>