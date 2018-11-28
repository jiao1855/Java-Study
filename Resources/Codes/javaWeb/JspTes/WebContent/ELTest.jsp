<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	pageContext.setAttribute("name", "pageContext");
	request.setAttribute("name", "request");
	session.setAttribute("name", "session");
	application.setAttribute("name", "application");
%>

<h1>普通取值</h1>
<%=	pageContext.getAttribute("name") %>
<%=	request.getAttribute("name") %>
<%=	session.getAttribute("name") %>
<%=	application.getAttribute("name") %>

<h1>EL表达式</h1>
${ pageScope.name }
${ requestScope.name }
${ sessionScope.name }
${ applicationScope.name }

<br>

//按作用域从小到大取值
${ name }
<br>

${ param.name }

<br>

<% String[] a = {"aa","bb","cc"};
	pageContext.setAttribute("array", a);
%>
${array[0] },${array[1] }

<br>

<% List list = new ArrayList();
	list.add("aa");
	list.add("bb");
	pageContext.setAttribute("list", list);
%>
${list[0] },${list[1] }
<br>

<% Map map = new HashMap();
	map.put("name","zhangsan");
	map.put("age",19);
	pageContext.setAttribute("student", map);
%>
${student.name } ${student.age }


</body>
</html>