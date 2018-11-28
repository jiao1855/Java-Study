<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Test1</h1>

<% 
	pageContext.setAttribute("name", "pageContext");
	request.setAttribute("name", "request");
	session.setAttribute("name", "session");
	application.setAttribute("name", "application");
%>

<%=	pageContext.getAttribute("name") %>
<%=	request.getAttribute("name") %>
<%=	session.getAttribute("name") %>
<%=	application.getAttribute("name") %>

</body>
</html>