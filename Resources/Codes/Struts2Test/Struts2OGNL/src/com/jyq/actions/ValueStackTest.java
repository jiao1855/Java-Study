package com.jyq.actions;

import com.jyq.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackTest extends ActionSupport {
	
	private User user;
	public User getUser() {
		return user;
	}

	@Override
	public String execute() throws Exception {
		user=new User("jyq","123");
		return SUCCESS;
	}
}
