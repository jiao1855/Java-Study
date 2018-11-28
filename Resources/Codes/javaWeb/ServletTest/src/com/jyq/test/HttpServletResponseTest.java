package com.jyq.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletResponseTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//test1(response);
		
		//1. 指定浏览器看这份数据使用的码表
		//response.setHeader("Content-Type", "text/html;charset=UTF-8");
		
		//2. 指定输出的中文用的码表也是UTF-8
		//getBytes()方法默认的码表是UTF-8，与Tomcat的默认码表没关系
		//response.getOutputStream().write("以字节流的方式写数据".getBytes());
		
		//使用以下一行设置，可代替两边两行设置，它告知浏览器，使用UTF-8编码
		response.setContentType("text/html;charset=UFT-8");
		response.getOutputStream().write("以字节流的方式写数据".getBytes());
	}

	private void test1(HttpServletResponse response) throws IOException {
		//以字符流的方式写数据		
		//1. 指定输出到客户端的时候，这些文字使用UTF-8编码
		response.setCharacterEncoding("UTF-8");
				
		//2. 直接规定浏览器看这份数据的时候，使用什么编码来看。
		response.setHeader("Content-Type", "text/html; charset=UTF-8");
				
		response.getWriter().write("以字符流的方式写数据");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
