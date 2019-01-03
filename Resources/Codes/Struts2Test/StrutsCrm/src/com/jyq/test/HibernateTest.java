package com.jyq.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.jyq.dao.CustomerDao;
import com.jyq.dao.impl.CustomerDaoImpl;
import com.jyq.domain.Customer;
import com.jyq.domain.User;
import com.jyq.utils.HibernateUtils;

public class HibernateTest {

	@Test
	public void test1() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 1L);
		System.out.println(customer.getCust_name());
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void test2() {
		CustomerDao customerDao = new CustomerDaoImpl();
		List<Customer> list = customerDao.findAll();
		for (Customer customer : list) {
			System.out.println(customer.getCust_name());
		}
	}
	
	@Test
	public void test3() {
		Session session = HibernateUtils.openSession();
		Query query = session.createQuery("from User ");
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user);
		}
		
	}
	
	@Test
	public void test4() {
		Session session = HibernateUtils.openSession();
		Query query = session.createQuery("from User where user_name=? and user_password=?");
		query.setParameter(0, "admin");
		query.setParameter(1, "1234");
		
		User user = (User)query.uniqueResult();
		System.out.println(user);
		
	}
}
