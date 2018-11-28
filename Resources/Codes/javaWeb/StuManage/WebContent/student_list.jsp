<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息管理系统</title>
</head>
<body>
<h1>学生列表</h1>
<table border="1">
	<tr>
		<th>ID</th>
		<th>姓名</th>
		<th>年龄</th>
		<th>姓别</th>
		<th>地址</th>
		<th>操作</th>
	</tr>
	
	<c:forEach var="stu" items="${sessionScope.stus }">
		<tr>
			<td>${ stu.id }</td>
			<td>${ stu.name }</td>
			<td>${ stu.age }</td>
			<td>${ stu.gender }</td>
			<td>${ stu.address }</td>
			<td><a href="#">更新</a> <a href="#">删除</a></td>
		</tr>
	</c:forEach>
	
</table>
</body>
</html>