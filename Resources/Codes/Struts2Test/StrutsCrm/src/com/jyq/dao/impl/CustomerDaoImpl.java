package com.jyq.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jyq.dao.CustomerDao;
import com.jyq.domain.Customer;
import com.jyq.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	public List<Customer> findAll() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Customer");
		List<Customer> customers = query.list();
		
		transaction.commit();
		session.close();
		
		return customers;
	}

	public void save(Customer customer) {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(customer);
		
		transaction.commit();
		session.close();
	}

}
