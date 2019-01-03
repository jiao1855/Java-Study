<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1:</h1>
<s:property value="user.name"/>
<s:property value="user.password"/>
${user.name }
<h1>2:</h1>
<s:property value="name"/>
<s:property value="password"/>
<h1>4:</h1>
<s:property value="list[0].name"/>
<s:property value="list[0].password"/>
<s:property value="list[1].name"/>
<s:property value="list[1].password"/>
<h1>5:</h1>

<s:property value="#request.name"/>
<s:property value="#session.name"/>
<s:property value="#application.name"/>
<!-- attr是按作用范围从小到大的域对象中提取数据 -->
<s:property value="#attr.name"/>

<s:debug></s:debug>
</body>
</html>