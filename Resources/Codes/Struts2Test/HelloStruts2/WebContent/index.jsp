<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${pageContext.request.contextPath }
<h3><a href="${pageContext.request.contextPath }/hello.action">Struts的入门</a></h3>

<h3>Action的访问：</h3>

<h4>1，通过配置method属性访问</h4>
<a href="userFind.action">查找用户</a>
<a href="userUpdate.action">修改用户</a>
<a href="userDelete.action">删除用户</a>
<a href="userSave.action">保存用户</a>
<br>

<h4>2，通过通配符的方式访问</h4>
<a href="user_find.action">查找用户</a>
<a href="user_update.action">修改用户</a>
<a href="user_delete.action">删除用户</a>
<a href="user_save.action">保存用户</a>

<br>

<h4>3，动态方法访问的方式访问</h4>
<a href="user!find.action">查找用户</a>
<a href="user!update.action">修改用户</a>
<a href="user!delete.action">删除用户</a>
<a href="user!save.action">保存用户</a>
<br>
<h3>Struts2 访问Servlet的API的三种方式：</h3>
<form action="${pageContext.request.contextPath }/ServletApiAccess1.action" method="post">
	姓名：<input type="text" name="name">
	密码：<input type="text" name="password">
	<input type="submit" value="提交">
</form>
<br>
<form action="${pageContext.request.contextPath }/ServletApiAccess2.action" method="post">
	姓名：<input type="text" name="name">
	密码：<input type="text" name="password">
	<input type="submit" value="提交">
</form>
<br>
<form action="${pageContext.request.contextPath }/ServletApiAccess3.action" method="post">
	姓名：<input type="text" name="name">
	密码：<input type="text" name="password">
	<input type="submit" value="提交">
</form>

<br>
<h3>Struts2的数据封装：</h3>
	<s:fielderror />
	<form action="${pageContext.request.contextPath }/StudentExecute1.action" method="post">
		姓名：<input type="text" name="name">
		年龄：<input type="text" name="age">
		生日：<input type="text" name="birthday">
		<input type="submit" value="提交">
	</form>
	<br>
	<form action="${pageContext.request.contextPath }/StudentExecute2.action" method="post">
		姓名：<input type="text" name="student.name">
		年龄：<input type="text" name="student.age">
		生日：<input type="text" name="student.birthday">
		<input type="submit" value="提交">
	</form>
	<br>
	<form action="${pageContext.request.contextPath }/StudentExecute3.action" method="post">
		姓名：<input type="text" name="name">
		年龄：<input type="text" name="age">
		生日：<input type="text" name="birthday">
		<input type="submit" value="提交">
	</form>
	
	<br>
	<form action="${pageContext.request.contextPath }/productList.action" method="post">
		名称：<input type="text" name="products[0].name">
		价格：<input type="text" name="products[0].price"><br>
		名称：<input type="text" name="products[1].name">
		价格：<input type="text" name="products[1].price"><br>
		名称：<input type="text" name="products[2].name">
		价格：<input type="text" name="products[2].price"><br>
		<input type="submit" value="提交">
	</form>
	<br>
	<form action="${pageContext.request.contextPath }/productMap.action" method="post">
		名称：<input type="text" name="map['one'].name">
		价格：<input type="text" name="map['one'].price"><br>
		名称：<input type="text" name="map['two'].name">
		价格：<input type="text" name="map['two'].price"><br>
		名称：<input type="text" name="map['three'].name">
		价格：<input type="text" name="map['three'].price"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>