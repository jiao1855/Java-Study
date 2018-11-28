<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jyq.test.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="name" value="jyq" scope="session"></c:set>
${ sessionScope.name }

<br>

<c:set var="age" value="32"></c:set>
<c:if test="${ age > 26 }">
	年龄大于26...
</c:if>

<br>

<c:set var="age" value="32"></c:set>
<c:if test="${ age > 26 }" var="flag" scope="session">
	年龄大于26...
</c:if>
${ flag }

<br>

<c:forEach begin="0" end="10" var="i" step="1">
	${ i }
</c:forEach>

<br>

<%
	List users = new ArrayList();
	users.add(new User("aa",21));
	users.add(new User("bb",32));
	pageContext.setAttribute("users", users);
%>

<c:forEach var="user" items="${ users }">
	${ user.name }
	${ user.age }
</c:forEach>

</html>