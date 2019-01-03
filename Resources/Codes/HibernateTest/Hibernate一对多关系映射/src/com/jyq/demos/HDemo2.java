package com.jyq.demos;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.jyq.domain2.Role;
import com.jyq.domain2.User;
import com.jyq.utils.HibernateUtils;

public class HDemo2 {
	
	@Test
	public void Test1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		User user1= new User();
		user1.setUser_name("jyq");
		User user2 = new User();
		user2.setUser_name("abc");
		
		Role role1 = new Role();
		role1.setRole_name("A");
		Role role2 = new Role();
		role2.setRole_name("B");
		Role role3 = new Role();
		role3.setRole_name("C");
		
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		user2.getRoles().add(role3);
		
		session.save(user1);
		session.save(user2);
		
		transaction.commit();
	}
	
	@Test
	public void Test2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, 3L);
		Role role1 = session.get(Role.class, 6L);
		Role role2 = session.get(Role.class, 8L);
		user.getRoles().remove(role1);
		user.getRoles().add(role2);
		
		transaction.commit();
	}
}
