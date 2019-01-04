package com.jyq.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jyq.dao.UserDao;

public class Demos {
	@Test
	public void test1() {
		ClassPathXmlApplicationContext factory = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao)factory.getBean("userDao");
		userDao.save();
		factory.close();
	}
	
	@Test
	public void test2() {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean1 bean1 = (Bean1)factory.getBean("bean1");
	}
	
	@Test
	public void test3() {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean2 bean2 = (Bean2)factory.getBean("beanFactory");
	}
	
	@Test
	public void test4() {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean1 bean1 = (Bean1)factory.getBean("bean1");
	}
	
	@Test
	public void test5() {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car = (Car)factory.getBean("car");
		System.out.println(car);
	}
	
	@Test
	public void test6() {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Car2 car2 = (Car2)factory.getBean("car2");
		System.out.println(car2);
	}
	
	@Test
	public void demo1() {
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext2.xml");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectionBean collectionBean = (CollectionBean) applicationContext.getBean("collectionBean");
		System.out.println(collectionBean);
	}
}
