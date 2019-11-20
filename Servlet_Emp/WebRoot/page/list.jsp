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
<title>员工列表示列</title>

<script type="text/javascript" src="${base}/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${base}/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="${base}/css/bootstrap/bootstrap.min.css"/> 

<style type="text/css">
	td{
	text-align: center;
	}
</style>
	
	
</head>
<body>
<div class="container"> <!--  定义布局容器 所有代码都写在容器里 -->
<div class="row">
	<div class="col-lg-12">
		<div class="row">
			<div class="col-lg-6 offset-lg-4" ><!-- style="overflow-y: scroll;height: 700px;" 进度条-->
				<table  class="table table-striped" >
				<thead>
					<tr>
						<td>编号</td>
						<td>姓名</td>
						<td>薪水</td>
						<td>年龄</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${emps}" var="emp" varStatus="s">
						<tr>
							<td>${emp.empId}</td>
							<td>${emp.empName}</td>
							<td>${emp.salary}</td>
							<td>${emp.age}</td>
							<td>
								<a href="${base}page/update.do?empId=${emp.empId}" class="btn btn-default">修改</a>
								<a href="${base}page/delete.do?empId=${emp.empId}" 
								onclick="return confirm('是否确定删除${emp.empName}')" class="btn btn-default">删除</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td align="center" colspan="6">
							<a href="${base}page/addEmp.jsp" class="btn btn-default">添加</a>
						</td>
					</tr>
					</tbody>
				</table>
			</div>
	   </div>
	</div>
</div>
</div>
	
</body>
</html>