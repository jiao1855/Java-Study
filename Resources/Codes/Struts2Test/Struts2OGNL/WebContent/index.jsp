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

<%@ taglib uri="/struts-tags" prefix="s" %>
<s:property value="'jyq'.length()"/>

<!-- 静态方法的访问在struts2中默认是关闭的，需要开启常量：
	struts.ognl.allowStaticMethodAccess=true 
-->
<s:property value="@java.lang.Math@random()"/>

<br><a href="${pageContext.request.contextPath }/test1.action">test1</a>
<br><a href="${pageContext.request.contextPath }/test2.action">test2</a>
<br><a href="${pageContext.request.contextPath }/test3.action">test3</a>
<br><a href="${pageContext.request.contextPath }/test4.action">test4</a>
<br><a href="${pageContext.request.contextPath }/test5.action">test5</a>
<br>

<s:iterator var="entry" value="#{'aa':'11','bb':'22','cc':'33' }">
	<s:property value="key"/> : <s:property value="value"/><br>
	<s:property value="#entry.key"/> : <s:property value="#entry.value"/><br>	
</s:iterator>

<s:radio list="#{'1':'男','2':'女' }" name="sex" label="性别"></s:radio>

<s:debug></s:debug>
</body>
</html>