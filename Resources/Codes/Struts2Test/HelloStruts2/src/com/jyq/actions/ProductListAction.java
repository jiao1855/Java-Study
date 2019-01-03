package com.jyq.actions;

import java.util.List;

import com.jyq.domain.Product;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport {
	
	private List<Product> products;
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String execute() throws Exception {
		for (Product product : products) {
			System.out.println(product);
		}
		return NONE;
	}
}
