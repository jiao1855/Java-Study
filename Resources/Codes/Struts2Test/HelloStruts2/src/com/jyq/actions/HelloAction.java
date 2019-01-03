package com.jyq.actions;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class HelloAction extends ActionSupport {
	
	@Override
	public String execute() throws Exception {
		System.out.println("Hello Struts2");
		return SUCCESS;
	}
	
	public String test() {
		System.out.println("test");
		return SUCCESS;
	}
}
