package com.jyq.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filename = request.getParameter("filename");	
		//设置响应头，表示内容以附件的方式处置
		response.setHeader("Content-Disposition", "attachment; filename="+filename);
			
		//获取文件的绝对路径
		String path = getServletContext().getRealPath("download/"+filename);
		InputStream is = new FileInputStream(path);
		OutputStream os = response.getOutputStream();
		
		int len = 0;
		byte[] buffer = new byte[1024];
		while ((len=is.read(buffer))!=-1) {
			os.write(buffer, 0, len);
		}
		os.close();
		is.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
