package com.jyq.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.jyq.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackTest5 extends ActionSupport {
	@Override
	public String execute() throws Exception {
		ValueStack stack = ActionContext.getContext().getValueStack();
		
		//直接向Servlet域对象中存数据，在值栈中可以通过访问context区域获取存放的数据
		ServletActionContext.getRequest().setAttribute("name", "requestValue");
		ServletActionContext.getRequest().getSession().setAttribute("name", "sessionValue");
		ServletActionContext.getServletContext().setAttribute("name", "appValue");
		return SUCCESS;
	}
}
