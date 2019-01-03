package com.jyq.service.impl;

import java.util.List;

import com.jyq.dao.CustomerDao;
import com.jyq.dao.impl.CustomerDaoImpl;
import com.jyq.domain.Customer;
import com.jyq.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	public List<Customer> findAll() {
		CustomerDao customerDao = new CustomerDaoImpl();
		return customerDao.findAll();
	}

	public void save(Customer customer) {
		CustomerDao customerDao = new CustomerDaoImpl();
		customerDao.save(customer);
	}

}
