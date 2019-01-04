package com.jyq.test;

public class Car2 {
	private String name;
	private Engine engine;
	
	
	public void setName(String name) {
		this.name = name;
	}

	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	@Override
	public String toString() {
		return "Car2 [name=" + name + ", engine=" + engine + "]";
	}
}
