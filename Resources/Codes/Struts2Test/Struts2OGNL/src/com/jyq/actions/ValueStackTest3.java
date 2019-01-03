package com.jyq.actions;

import com.jyq.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackTest3 extends ActionSupport {
	@Override
	public String execute() throws Exception {
		ValueStack stack = ActionContext.getContext().getValueStack();
		User user = new User("jyq","123");
		stack.push(user);
		return SUCCESS;
	}
}
