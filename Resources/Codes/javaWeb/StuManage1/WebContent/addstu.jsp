<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="AddStudentServlet" method="post">
	<table border="1" width="600">
		<tr>
			<td>姓名</td>
			<td><input type="text" name="sname" /></td>
		<tr>
		<tr>
			<td>性别</td>
			<td>
				<input type="radio" name="gender" value="男">男
				<input type="radio" name="gender" value="女">女
			</td>
		<tr>
		<tr>
			<td>电话</td>
			<td><input type="text" name="phone" /></td>
		<tr>
		<tr>
			<td>生日</td>
			<td><input type="text" name="birthday" /></td>
		<tr>
		<tr>
			<td>爱好</td>
			<td>
				<input type="checkbox" name="hobby" value="游泳">游泳
				<input type="checkbox" name="hobby" value="篮球">篮球
				<input type="checkbox" name="hobby" value="足球">足球
				<input type="checkbox" name="hobby" value="看书">看书
				<input type="checkbox" name="hobby" value="写字">写字	
			</td>
		<tr>
		<tr>
			<td>简介</td>
			<td>
				<textarea name="info" rows="3" cols="20"></textarea>
			</td>
		<tr>
		<tr>
			<td colspan="2"><input type="submit" value="添加"></td>
		<tr>
	</table>
</form>
</body>
</html>