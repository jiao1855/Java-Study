package com.jyq.service;

import java.util.List;

import com.jyq.domain.Customer;

public interface CustomerService {
	public List<Customer> findAll();

	public void save(Customer customer);
}
