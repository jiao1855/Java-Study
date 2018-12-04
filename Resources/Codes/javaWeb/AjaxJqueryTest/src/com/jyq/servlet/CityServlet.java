package com.jyq.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jyq.dao.CityDao;
import com.jyq.dao.impl.CityDaoImpl;
import com.jyq.domain.CityBean;
import com.thoughtworks.xstream.XStream;

public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//获取参数
			int pid = Integer.parseInt(request.getParameter("pid"));
			
			//查询省份对应的所有城市
			CityDao cityDao = new CityDaoImpl();
			List<CityBean> cityList = cityDao.findCityByPid(pid);
			
			//使用XStream框架将实体类集合转化成 xml
			XStream xStream = new XStream();
			xStream.alias("city", CityBean.class);
			String xml = xStream.toXML(cityList);
			
			//返回数据
			response.setContentType("text/xml;charset=utf-8");
			response.getWriter().write(xml);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
