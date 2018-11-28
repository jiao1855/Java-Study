package com.jyq.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get请求过来的数据，在url地址栏上就已经经过编码了;
		//getParameter()方法默认使用ISO-8859-1去解码,所以造成中文乱码
		String username = request.getParameter("username");
		String password = request.getParameter("password");		
		System.out.println("username="+username);	//username=éå²
		
		//要解决中文乱码，先让文字回到ISO-8859-1对应的字节数组 ， 然后再按utf-8组拼字符串
		username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("username="+username);	//username=青岛
		
		//向客户端输出内容
		PrintWriter writer = response.getWriter();
		if("admin".equals(username)&&"123".equals(password)) {
			//writer.write("login success");
			
			//如果登陆成功，获取之前的登陆成功次数并且加1，使用ServletContext的getAttribute()把登陆次数存到全局变量里.
			Object obj = getServletContext().getAttribute("count");
			int count = 0;
			if(obj!=null) {
				count = (int)obj;
			}
			getServletContext().setAttribute("count", count+1);
			
			//登陆成功就跳转到 login_success.html
			response.setStatus(302);	//设置状态码
			response.setHeader("Location", "login_success.html");
		} else {
			writer.write("login failed");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setCharacterEncoding()方法用来设置请求体里面的文字编码,这行设置一定要写在getParameter之前。
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		System.out.println("username="+username);

		
	}

}
