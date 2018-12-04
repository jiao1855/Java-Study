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

import net.sf.json.JSONArray;

public class CityJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//获取参数
			int pid = Integer.parseInt(request.getParameter("pid"));
			
			//查询省份对应的所有城市
			CityDao cityDao = new CityDaoImpl();
			List<CityBean> cityList = cityDao.findCityByPid(pid);
			
			//3. 把list 转化成 json数据
			//JSONArray ---> 变成数组 ， 集合  []
			//JSONObject ---> 变成简单的数据  { name : zhangsan , age:18}
			
			JSONArray jsonArray = JSONArray.fromObject(cityList);
			String json = jsonArray.toString();

			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(json);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
