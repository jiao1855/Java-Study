package com.jyq.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ServletContextTest
 */
public class ServletContextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		String address = servletContext.getInitParameter("address");
		//System.out.println(address);
		
		//这里得到的是项目在tomcat里面的根目录。
		String path = servletContext.getRealPath("");
		System.out.println(path);
		
		//根据相对路径获取文件的绝对路径
		path = servletContext.getRealPath("Files/config.properties");
		System.out.println(path);
		
		//根据相对路径直接获取到流对象
//		InputStream inputStream = servletContext.getResourceAsStream("Files/config.properties");
//		Properties prop = new Properties();
//		prop.load(inputStream);
//		String addr = prop.getProperty("address");
//		System.out.println(addr);
		
		//获取这个Java源文件所对应的class文件，再获取加载此class文件的类加载器.
		//类加载器所对应的根路径是Tomcat项目根路径里的WEB-INF/classes,所以要使用../../返回项目根路径
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("../../Files/config.properties");
		Properties prop = new Properties();
		prop.load(inputStream);
		String addr = prop.getProperty("address");
		System.out.println(addr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
