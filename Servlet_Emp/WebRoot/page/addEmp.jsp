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
<title>员工添加示列</title>

<script type="text/javascript" src="${base}/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${base}/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="${base}/css/bootstrap/bootstrap.min.css"/> 
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-4 offset-lg-5">
			
				<form action="addEmp.do" method="post" class="form-horizontal">
					
					<div class="form-group">
						<label for="name">姓名</label>
						<input type="text" id="name" name="name" class="form-control" />
					</div>
					
					<div class="form-group">
						<label for=salary>工资</label>
						<input type="text" id="salary" name="salary" class="form-control" />
					</div>
					
					<div class="form-group">
						<label for="age">年龄</label>
						<input type="text" id="age" name="age" class="form-control" />
					</div>
					<input type="submit" class="form-control btn btn-primary" value="提交">
				</form>	
						
			</div>
		</div>
	</div>
</body>
</html>