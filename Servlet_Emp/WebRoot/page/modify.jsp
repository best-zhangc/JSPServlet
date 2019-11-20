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
<title>员工修改示列</title>

<script type="text/javascript" src="${base}/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${base}/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="${base}/css/bootstrap/bootstrap.min.css"/> 
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-4 offset-lg-5">
			
			<form action="modify.do" method="post" class="form-horizontal">
				<input type="hidden" value="${emp.empId}" name="empId"/>
				<div class="form-group">
					<label for="empName">姓名</label>
					<input type="text" name="empName" id="empName" class="form-control" value="${emp.empName}" />
				</div>
				
				<div class="form-group">
					<label for="salary">薪水</label>
					<input type="text" name="salary" id= "salary" class ="form-control" value="${emp.salary }"/>
				</div>
				
				<div class = "form-group">
					<label for = "age">年龄</label>
					<input type = "text" name = "age" id = "age" class = "form-control" value = "${emp.age}" />
				</div>	
				<input type="submit" value="提交" class="form-control btn btn-primary"/>			
			</form>
			
			</div>
		</div>
	</div>
</body>
</html>