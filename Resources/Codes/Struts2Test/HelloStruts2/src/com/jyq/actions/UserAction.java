package com.jyq.actions;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	public String find() {
		System.out.println("查找用户");
		return NONE;
	}
	
	public String update() {
		System.out.println("修改用户");
		return NONE;
	}
	
	public String delete() {
		System.out.println("删除用户");
		return NONE;
	}
	
	public String save() {
		System.out.println("保存用户");
		return NONE;
	}
}
