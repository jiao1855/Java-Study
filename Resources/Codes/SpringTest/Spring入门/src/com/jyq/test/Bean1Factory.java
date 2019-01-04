package com.jyq.test;

public class Bean1Factory {
	public Bean1 createBean1() {
		System.out.println("Bean1被创建了");
		return new Bean1();
	}
}
