<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function doDelete(sid) {
		var flag = confirm("是否确定删除？");
		if(flag){
			location.href="DeleteStuServlet?sid="+sid;
		}
	}
</script>

</head>
<body>
<form action="LikeSearchStudentsServlet" method="post">
	<table border="1" width="800">
		<tr>
			<td colspan="8">
				姓名：<input type="text" name="sname" value=${ name }>
				性别：<select name="gender">
					<option value="" <c:if test="${ fn:length(gender) == 0 }">selected</c:if>>--请选择--
					<option value="男" <c:if test="${ gender == '男' }">selected</c:if>>男
					<option value="女" <c:if test="${ gender == '女' }">selected</c:if>>女
				</select>
				<input type="submit" value="查询" >
				
				<a href="addstu.jsp">添加</a>
			</td>
		<tr>
		<tr align="center">
			<th>ID</th>
			<th>姓名</th>
			<th>性别</th>
			<th>电话</th>
			<th>生日</th>
			<th>爱好</th>
			<th>简介</th>
			<th>操作</th>
		</tr>
		<c:forEach var="stu" items="${ stus }">
			<tr align="center">
				<td>${ stu.sid }</td>
				<td>${ stu.sname }</td>
				<td>${ stu.gender }</td>
				<td>${ stu.phone }</td>
				<td>${ stu.birthday }</td>
				<td>${ stu.hobby }</td>
				<td>${ stu.info }</td>
				<td><a href="EditStudentServlet?sid=${stu.sid }">更新</a> <a href="#" onclick="doDelete(${stu.sid})">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>