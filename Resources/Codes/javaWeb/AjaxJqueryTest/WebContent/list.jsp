<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table style="width: 100%">
	<c:forEach items="${list }" var="wordBean">
		<tr>
			<td>${wordBean.word}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>