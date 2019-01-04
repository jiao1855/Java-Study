package com.jyq.actions;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.BeanFactory;

import com.jyq.domain.User;
import com.jyq.service.CustomerService;
import com.jyq.service.UserService;
import com.jyq.service.impl.UserServiceImpl;
import com.jyq.utils.SpringUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	public User getModel() {
		return user;
	}
	
	public String login() {
		System.out.println(user);
		//调用Service判断此用户是否存在
		//UserService userService = new UserServiceImpl();
		UserService userService = getUserService();
		User existUser = userService.find(user);
		System.out.println(existUser);
		if(existUser==null) {
			this.addActionError("用户名或密码错误!");
			return LOGIN;
		}
		else {
			//登陆成功,将用户对象存入Session中
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return SUCCESS;
		}
	}
	
	private UserService getUserService() {
		BeanFactory beanFactory = SpringUtils.getBeanFactory();
		return (UserService) beanFactory.getBean("userService");
	}


	
}
