package com.jyq.dao;

import java.util.List;

import com.jyq.domain.Customer;

public interface CustomerDao {
	public List<Customer> findAll();

	public void save(Customer customer);
}
