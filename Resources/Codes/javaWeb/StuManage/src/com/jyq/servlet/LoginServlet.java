package com.jyq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jyq.dao.StudentDao;
import com.jyq.dao.UserDao;
import com.jyq.dao.impl.StudentDaoImpl;
import com.jyq.dao.impl.UserDaoImpl;
import com.jyq.domain.Student;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//因为是post请求，所以请求体中有可能包含中文，所以在读取客户数据时先指定编码。
		request.setCharacterEncoding("UTF-8");
		//指定响应的数据及浏览器中的数据使用UTF-8编码.
		response.setContentType("text/html;charset=UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+" "+password);
		
		UserDao userDao = new UserDaoImpl();
		boolean isSuccess = userDao.login(username, password);
		if(isSuccess) {
			//response.getWriter().write("登陆成功！");
			
			//把学生数据存放到session中
			StudentDao studentDao = new StudentDaoImpl();
			List<Student> students = studentDao.findAll();
			request.getSession().setAttribute("stus", students);
			
			response.sendRedirect("student_list.jsp");
		}
		else {
			response.getWriter().write("登陆失败！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
