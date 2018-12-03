package com.jyq.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jyq.domain.Student;
import com.jyq.service.StudentService;
import com.jyq.service.impl.StudentServiceImpl;

public class LikeSearchStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			
			String name = request.getParameter("sname");
			String gender = request.getParameter("gender");
			
			StudentService studentService = new StudentServiceImpl();
			List<Student> students = studentService.findStudents(name, gender);
			
			request.setAttribute("name", name);
			request.setAttribute("gender", gender);
			
			request.setAttribute("stus", students);
			request.getRequestDispatcher("stulist.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
