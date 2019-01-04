package com.jyq.test;

public class Engine {
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Engine [name=" + name + "]";
	}
}
