package com.jyq.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor1 extends AbstractInterceptor {
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("MyInterceptor1执行了");
		String obj = invocation.invoke();
		System.out.println("MyInterceptor1执行结束了");
		return obj;
	}
}
