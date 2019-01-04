package com.jyq.dao.impl;
import com.jyq.dao.UserDao;

public class UserDaoImpl implements UserDao {
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	
	public void init() {
		System.out.println("UserDaoImpl类被创建了");
	}
	
	public void save() {
		System.out.println("UserDaoImpl执行了..."+name);
	}
	
	public void destroy() {
		System.out.println("UserDaoImpl类被销毁了");
	}
}
