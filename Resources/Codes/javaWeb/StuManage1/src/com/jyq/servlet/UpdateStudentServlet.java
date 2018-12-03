package com.jyq.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jyq.domain.Student;
import com.jyq.service.StudentService;
import com.jyq.service.impl.StudentServiceImpl;

public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//客户端提交过来的数据有可能有中文
		request.setCharacterEncoding("UTF-8");
		
		try {
			int sid = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday");
			//String hobby = request.getParameter("hobby");
			String[] values = request.getParameterValues("hobby");
			String hobby = String.join(",", values);
			String info = request.getParameter("info");
			Date birth = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student stu = new Student(sname, gender, phone, birth, hobby, info);
			stu.setSid(sid);
			
			//更新到数据库
			StudentService stuService = new StudentServiceImpl();
			stuService.updateStudent(stu);
			
			//返回学生列表
			request.getRequestDispatcher("SearchStudentsServlet").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
