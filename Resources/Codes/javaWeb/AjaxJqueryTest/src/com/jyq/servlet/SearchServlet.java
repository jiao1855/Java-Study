package com.jyq.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jyq.domain.WordBean;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String word = request.getParameter("word");
		System.out.println(word);
		
		List<WordBean> list = new ArrayList<WordBean>();
		list.add(new WordBean("AA"));
		list.add(new WordBean("AB"));
		list.add(new WordBean("AC"));
		list.add(new WordBean("BB"));
		list.add(new WordBean("CC"));
		
		request.setAttribute("list", list);
		
		//返回数据
		response.setContentType("text/html;charset=utf-8");
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
