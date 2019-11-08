<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%--方法一： --%>  
<%--     <%
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    		for(Cookie c : cookies){
    			String name = c.getName() ;
    			String value = c.getValue() ;
    			out.print("<h3>Name: " + name +
    					" Value: " + value + "</h3>");
    		}
    	} else{
    		out.print("没有Cookie信息");
    	}
    %> --%>
    
    <%--方法二： --%>  
    <%
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null ){
    		for(int i =0 ; i<cookies.length ; i++){
    		Cookie	currCookies =cookies[i] ;
    		String name = currCookies.getName() ;
    		String value = currCookies.getValue() ;
    		out.print("<h3> Name :" +name+ 
    				"   Value:" +value+ "</h3>");
    		}
    	}else{
    		out.print("<h1>NO Cookie</h1>");
    	}
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Cookie 查找操作</h1>
</body>
</html>