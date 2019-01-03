package com.jyq.actions;

import com.opensymphony.xwork2.ActionSupport;

public class Test1Action extends ActionSupport {
	@Override
	public String execute() throws Exception {
		System.out.println("test1");
		return NONE;
	}
}
