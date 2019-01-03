package com.jyq.actions;

import java.util.List;
import java.util.Map;

import com.jyq.domain.Product;
import com.opensymphony.xwork2.ActionSupport;

public class ProductMapAction extends ActionSupport {
	
	private Map<String, Product> map;
	public Map<String, Product> getMap() {
		return map;
	}
	public void setMap(Map<String, Product> map) {
		this.map = map;
	}

	@Override
	public String execute() throws Exception {
		for(String key:map.keySet()) {
			System.out.println(key+":"+map.get(key));
		}
		return NONE;
	}
}
