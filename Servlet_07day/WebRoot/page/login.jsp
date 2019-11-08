<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!--输入错误传值到前台显示  -->   
<%=request.getAttribute("msg")%>
<style type="text/css">
<!--
	.s1{
		cursor: pointer;
	}
-->
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 实现登录</title>
</head>
<body>
	<form action="login.do" method="post">
		<fieldset>
			<legend>登录</legend>
			用户名：<input type="text" name="uname"/><br><br>
			密　码：<input type="password" name="pwd"/><br><br>
			验证码：<input name = "vcode">
			<img src="code" onclick="this.src ='code?'+Math.random();" class="s1" title="点击更换"><br><br>
			<input type="submit" value="登录"/>
		</fieldset>
	</form>
</body>
</html>