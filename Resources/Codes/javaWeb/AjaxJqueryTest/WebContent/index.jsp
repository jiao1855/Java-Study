<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	
	function get(){
		//1，创建XMLHttpRequest对象。
		var request = new XMLHttpRequest();
		//2，发送请求，可带请求参数
		request.open("GET","AjaxRequestProcessServlet?name=jyq",true);
		//3，注册onreadystatechange事件，获取响应数据
		request.onreadystatechange=function(){
			if(request.readyState==4 && request.status==200){
				alert(request.responseText);
			}
		}
		//4，发送请求
		request.send();
	}
	
	function post(){
		//1，创建XMLHttpRequest对象。
		var request = new XMLHttpRequest();
		//2，发送请求，可带请求参数
		request.open("POST","AjaxRequestProcessServlet",true);
		//3，注册onreadystatechange事件，获取响应数据
		request.onreadystatechange=function(){
			if(request.readyState==4 && request.status==200){
				alert(request.responseText);
			}
		}
		
		//4，如果不发送请求数据，直接send()
		//request.send();
		
		//5，如果要发送请求数据，则写以下两行
		//如果使用的是post方式且带数据，那么这里要添加HTTP头，说明提交的数据类型是一个经过url编码的form表单数据
		request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		//在send方法里写表单数据
		request.send("name=jyq");
	}
	
	function checkUsername(){
		//获取用户名
		var username = document.getElementById("username").value;
		//异步向服务器发送请求查询是否存在用户名
		//1，创建XMLHttpRequest对象。
		var request = new XMLHttpRequest();
		//2，发送请求，可带请求参数
		request.open("POST","CheckUsernameServlet",true);
		//3，注册onreadystatechange事件，获取响应数据
		request.onreadystatechange=function(){
			if(request.readyState==4 && request.status==200){
				var data = request.responseText;
				if(data==1){
					document.getElementById("msg").innerHTML=
						"<font color='red'>用户名已存在!</font>";
				}
				else{
					document.getElementById("msg").innerHTML=
						"<font color='green'>用户名可用!</font>";
				}
			}
		}
		
		//4，如果要发送请求数据，写以下两行
		//如果使用的是post方式且带数据，那么这里要添加HTTP头，说明提交的数据类型是一个经过url编码的form表单数据
		request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		//在send方法里写表单数据
		request.send("name="+username);
	}
	
	function jqueryLoad(){
		$("#msgJquery").load("AjaxRequestProcessServlet");
		$("#msgJquery").load("AjaxRequestProcessServlet?name=jyq");
		$("#msgJquery").load("AjaxRequestProcessServlet",{name:"jyq",age:18});
		$("#msgJquery").load("AjaxRequestProcessServlet",{name:"jyq",age:18},
			function(responseTxt,statusTxt,xhr){
				if(statusTxt=="success")
					alert("外部内容加载成功！");
			    if(statusTxt=="error")
					alert("Error: "+xhr.status+": "+xhr.statusText);
		});
	}
	
	function jqueryGet(){
		$.get("AjaxRequestProcessServlet?name=jyq&age=19",
			function(responseTxt,statusTxt,xhr){
				if(statusTxt=="success")
					//xhr.status=200, xhr.statusText=OK
					$("#msgJquery").html(responseTxt);
			    if(statusTxt=="error")
					alert("Error: "+xhr.status+": "+xhr.statusText);
		});
	}
	
	function jqueryPost(){
		$.post("AjaxRequestProcessServlet",{name:"jyq",age:19},
			function(a,b,c){
				if(b=="success")
					//xhr.status=200, xhr.statusText=OK
					$("#msgJquery").html(a);
			    if(b=="error")
					alert("Error: "+c.status+": "+c.statusText);
		});
	}
	
function checkUsernameJq(){
	//获取用户名
	var username = $("#usernameJq").val();
	//异步向服务器发送请求查询是否存在用户名
	$.post("CheckUsernameServlet",{name:username},
		function(data,status){
			if(data==1){
				$("#msgJq").html("<font color='red'>用户名已存在!</font>");
			}
			else{
				$("#msgJq").html("<font color='green'>用户名可用!</font>");
			}
	});
}

</script>
</head>
<body>

<h1>原始Ajax</h1>
<input type="button" onclick="get()" value="get 请求"><br>
<input type="button" onclick="post()" value="post 请求"><br>
<table>
	<tr>
		<td>用户名</td>
		<td>
			<input type="text" name="username" id="username" onblur="checkUsername()">
			<span id="msg"></span>
		</td>
	</tr>
	<tr>
		<td>密码</td>
		<td><input type="text" name="password" id="password"></td>
	</tr>
</table>

<h1>Jquery Ajax</h1>

<input type="button" onclick="jqueryLoad()" value="jquery load 请求"><br>
<input type="button" onclick="jqueryGet()" value="jquery get 请求"><br>
<input type="button" onclick="jqueryPost()" value="jquery post 请求"><br>
<span id="msgJquery"></span>
<table>
	<tr>
		<td>用户名</td>
		<td>
			<input type="text" name="usernameJq" id="usernameJq" onblur="checkUsernameJq()">
			<span id="msgJq"></span>
		</td>
	</tr>
	<tr>
		<td>密码</td>
		<td><input type="text" name="passwordJq" id="passwordJq"></td>
	</tr>
</table>
</body>
</html>