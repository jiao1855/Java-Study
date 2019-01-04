package com.jyq.test;

import java.util.Random;

public class CarInfo {
	private String name;
	public String getName() {
		return "摩托车";
	}
	
	public Double calcPrice() {
		return new Random().nextDouble()*10000;
	}
}
