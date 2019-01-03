package com.jyq.actions;

import java.util.ArrayList;
import java.util.List;

import com.jyq.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackTest4 extends ActionSupport {
	@Override
	public String execute() throws Exception {
		ValueStack stack = ActionContext.getContext().getValueStack();
		List<User> list = new ArrayList<User>();
		list.add(new User("jyq","123"));
		list.add(new User("abc","111"));
		stack.set("list", list);
		return SUCCESS;
	}
}
