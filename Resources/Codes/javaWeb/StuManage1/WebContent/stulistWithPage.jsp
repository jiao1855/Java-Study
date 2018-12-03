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
		<c:forEach var="stu" items="${ pageBean.list }">
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
		<tr>
			<td colspan="8">
				第 ${pageBean.currentPage } / ${pageBean.totalPage }
			  		&nbsp;&nbsp;
			  		每页显示${pageBean.pageSize }条  &nbsp;&nbsp;&nbsp;
			  		总的记录数${pageBean.totalSize } &nbsp;&nbsp;&nbsp;
			  		<c:if test="${pageBean.currentPage !=1 }">
			  			<a href="SearchStudentsPageServlet?currentPage=1">首页</a>
						| <a href="SearchStudentsPageServlet?currentPage=${pageBean.currentPage-1 }">上一页</a>
			  		</c:if>
			  		
			  		<c:forEach begin="1" end="${pageBean.totalPage }" var="i">
			  			<c:if test="${pageBean.currentPage == i }">
			  				${i }
			  			</c:if>
			  			<c:if test="${pageBean.currentPage != i }">
			  				<a href="SearchStudentsPageServlet?currentPage=${i }">${i }</a>
			  			</c:if>
			  		
			  		</c:forEach>
			  		
			  		
			  		<c:if test="${pageBean.currentPage !=pageBean.totalPage }">
			  			<a href="SearchStudentsPageServlet?currentPage=${pageBean.currentPage+1 }">下一页</a> | 
			  			<a href="SearchStudentsPageServlet?currentPage=${pageBean.totalPage }">尾页</a>
			  		</c:if>
			</td>
		</tr>
	</table>
</form>
</body>
</html>