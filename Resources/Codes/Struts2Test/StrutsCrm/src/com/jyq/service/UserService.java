package com.jyq.service;

import com.jyq.domain.User;

public interface UserService {
	/**
	 * 判断是否存在此用户
	 * @param user
	 * @return
	 */
	public User find(User user);
}
