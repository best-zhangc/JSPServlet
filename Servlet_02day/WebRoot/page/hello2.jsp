<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ServletTest _02</title>
<meta http-equiv = "content-type" content = "text/html ; charset = UTF-8" >
</head>
<body>
		<form action="hello2" method="get">
		姓　　名：<input type="text" name="name"><br>
		联系方式：<br>
		QQ: <input type="checkbox" name="contact" value="QQ">
		电话：<input type="checkbox" name="contact" value="tel">
		微信：<input type="checkbox" name="contact" value="weChat"><br>
		<input type="submit" value="确定">
	</form>
</body>
</html>