package com.jyq.service.impl;

import com.jyq.dao.UserDao;
import com.jyq.dao.impl.UserDaoImpl;
import com.jyq.domain.User;
import com.jyq.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User find(User user) {
		//UserDao userDao = new UserDaoImpl();
		return userDao.find(user);
	}

}
