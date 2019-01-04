package com.jyq.actions;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.BeanFactory;

import com.jyq.domain.Customer;
import com.jyq.service.CustomerService;
import com.jyq.service.impl.CustomerServiceImpl;
import com.jyq.utils.SpringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	
	private CustomerService getCustomerService() {
		BeanFactory beanFactory = SpringUtils.getBeanFactory();
		return (CustomerService) beanFactory.getBean("customerService");
	}
	
	public String find() {
		// 调用业务层
		//CustomerService customerService = new CustomerServiceImpl();
		CustomerService customerService = getCustomerService();
		List<Customer> list = customerService.findAll();
		// 页面跳转
		//ServletActionContext.getRequest().setAttribute("list", list);
		ActionContext.getContext().getValueStack().set("list", list);
		return "findSuccess";
	}
	
	private Customer customer = new Customer();
	public Customer getModel() {
		return customer;
	}
	
	public String saveUI() {
		return "saveUI";
	}
	
	public String save() {
		//CustomerService customerService = new CustomerServiceImpl();
		CustomerService customerService = getCustomerService();
		customerService.save(customer);
		
		//页面跳转
		List<Customer> list = customerService.findAll();
		//ActionContext.getContext().put("list", list);
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveSuccess";
	}

	
}
