package com.jyq.test;

public class BeanFactory {
	public static Bean2 createBean2() {
		System.out.println("Bean2被创建了");
		return new Bean2();
	}
}
