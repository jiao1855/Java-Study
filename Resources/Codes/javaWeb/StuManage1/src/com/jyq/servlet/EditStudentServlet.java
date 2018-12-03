package com.jyq.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jyq.domain.Student;
import com.jyq.service.StudentService;
import com.jyq.service.impl.StudentServiceImpl;

public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			int sid = Integer.parseInt(request.getParameter("sid"));
			StudentService stuService = new StudentServiceImpl();
			Student stu = stuService.findStudentById(sid);
			
			request.setAttribute("stu", stu);
			
			request.getRequestDispatcher("editstu.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
