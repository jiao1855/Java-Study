package com.jyq.utils;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringUtils {
	public static BeanFactory getBeanFactory() {
		//return new ClassPathXmlApplicationContext("applicationContext.xml");
		return getWebApplicationContext();
	}
	
	public static WebApplicationContext getWebApplicationContext() {
		ServletContext servletContext = ServletActionContext.getServletContext();
		return WebApplicationContextUtils.getWebApplicationContext(servletContext);
	}
}
