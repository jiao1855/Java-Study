package com.jyq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jyq.domain.PageBean;
import com.jyq.domain.Student;
import com.jyq.service.StudentService;
import com.jyq.service.impl.StudentServiceImpl;

public class SearchStudentsPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1,获取需要显示的页码数
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			//2,查询指定页的数据
			StudentService stuService = new StudentServiceImpl();
			PageBean<Student> pageBean = stuService.findStudentByPage(2, currentPage);
			request.setAttribute("pageBean", pageBean);
			//3,跳转页面
			request.getRequestDispatcher("stulistWithPage.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
