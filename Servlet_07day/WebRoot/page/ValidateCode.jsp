<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>验证码</title>
<style type="text/css">
		.s1{
		cursor:pointer ;
		position: relative;
		top:12px;
		/* margin-top: 30px ; */
	}
</style>

</head>
<body>
	<div>
	
		验证码：<input name="vcode" />
		<img  src="code" onclick="this.src ='code?'+Math.random();" class="s1" title="点击更换" />
		</div>
</body>
</html>