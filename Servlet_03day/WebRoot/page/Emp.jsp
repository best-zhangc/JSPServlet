<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html ; charset = UTF-8">
	<title>ServletTest_03</title>
	
</head>
<body style="font-size: 24px">
	<form action="ServletEmp" method="post">
		<fieldset>
			<legend>添加员工</legend>
			姓名：<input type="text" name="name"><br>
			薪水：<input type="text" name="salary"><br>
			年龄：<input type="text" name="age"><br>
			<input type="submit" value ="添加">
		</fieldset>
	</form>
</body>
</html>