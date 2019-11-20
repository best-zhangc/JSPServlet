<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:url var="base" value="/"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>页面出错</title>

<script type="text/javascript" src="${base}/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${base}/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="${base}/css/bootstrap/bootstrap.min.css"/> 
</head>
<body>
	<% 
	String error =(String)request.getAttribute("error") ;
	%>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-4">404 Not Found</h1>
			<p class="lead">
				<strong class="text-white bg-info"><%=error%></strong>
			</p>
			<a href="${base}page/list.jssp" class="btn btn-primary btn-lg" role="button">
				<strong>返回主页</strong>
			</a>
		</div>
	</div>
</body>
</html>