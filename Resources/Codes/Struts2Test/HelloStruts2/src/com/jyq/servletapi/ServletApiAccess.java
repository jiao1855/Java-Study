package com.jyq.servletapi;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ServletApiAccess extends ActionSupport implements ServletRequestAware {
	
	private HttpServletRequest request;

	public String execute1() throws Exception {
		
		
		ActionContext context = ActionContext.getContext();
		Map<String, Object> map = context.getParameters();
		for(String key : map.keySet()) {
			System.out.println(key+":"+Arrays.toString((String[])map.get(key)));
		}
		
		//向域对象存入数据
		//相当于request.setAttribute();
		context.put("requestName", "requestValue");
		//相当于session.setAttribute();
		context.getSession().put("sessionName", "sessionValue");
		//相当于application.setAttribute();
		context.getApplication().put("applicationName", "applicationValue");
		
		return SUCCESS;
	}
	
	public String execute2() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> map = request.getParameterMap();
		for(String key : map.keySet()) {
			System.out.println(key+":"+Arrays.toString(map.get(key)));
		}
		
		//向域对象存入数据
		request.setAttribute("requestName", "requestValue");
		request.getSession().setAttribute("sessionName", "sessionValue");
		ServletActionContext.getServletContext().setAttribute("applicationName", "applicationValue");
		
		return SUCCESS;
	}
	
	public String execute3() throws Exception {
		
		Map<String, String[]> map = request.getParameterMap();
		for(String key : map.keySet()) {
			System.out.println(key+":"+Arrays.toString(map.get(key)));
		}
		
		//向域对象存入数据
		request.setAttribute("requestName", "requestValue");
		request.getSession().setAttribute("sessionName", "sessionValue");
		
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
}
