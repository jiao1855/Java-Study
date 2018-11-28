<%@ page language="java" contentType="text/html; charset=UTF-8"
errorPage="error.jsp" pageEncoding="UTF-8"%>




<jsp:forward page="test1.jsp">
	<jsp:param value="chinasoft" name="company"/>
</jsp:forward>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Jsp test</h1>
</body>
</html>