package com.home_server;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("view")
public class ProductListController {
	@Resource
	private ProductRepository productRepository;

	private List<Product> products;

	public void loadData() {
		products = productRepository.findAll();
	}

	public List<Product> getProducts() {
		return products;
	}
}
