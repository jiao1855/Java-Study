<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息管理系统</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		用户名：<input type="text" name="username" /> <br>
		密    码：<input type="text" name="password" /> <br>
		<input type="submit" value="登陆" />
	</form>
</body>
</html>