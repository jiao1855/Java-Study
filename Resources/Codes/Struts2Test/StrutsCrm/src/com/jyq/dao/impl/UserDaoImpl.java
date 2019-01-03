package com.jyq.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jyq.dao.UserDao;
import com.jyq.domain.User;
import com.jyq.utils.HibernateUtils;

public class UserDaoImpl implements UserDao {

	public User find(User user) {
		Session session = HibernateUtils.openSession();
		Query query = session.createQuery("from User where user_name=? and user_password=?");
		query.setParameter(0, user.getUser_name());
		query.setParameter(1, user.getUser_password());
		
		Object result = query.uniqueResult();
		if(result!=null)
			return (User)result;
		return null;
	}
}
