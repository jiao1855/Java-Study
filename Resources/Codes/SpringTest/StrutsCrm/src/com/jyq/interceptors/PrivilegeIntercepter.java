package com.jyq.interceptors;

import org.apache.struts2.ServletActionContext;

import com.jyq.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeIntercepter extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//判断Session中是否有用户数据
		User existUser = (User)ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(existUser==null) {
			//没有登陆，给出提示信息
			ActionSupport action = (ActionSupport)invocation.getAction();
			action.addActionError("没有登陆，请登陆");
			return action.LOGIN;
		}
		else {
			//已经登陆，放行
			return invocation.invoke();
		}
	}

}
