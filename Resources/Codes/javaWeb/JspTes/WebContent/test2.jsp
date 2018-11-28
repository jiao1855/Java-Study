<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<%=	pageContext.getAttribute("name") %> <br>
<%=	request.getAttribute("name") %> <br>
<%=	session.getAttribute("name") %> <br>
<%=	application.getAttribute("name") %><br>

<% out.write("out输出的内容");
   response.getWriter().write("response 输出的内容"); %>

</body>
</html>