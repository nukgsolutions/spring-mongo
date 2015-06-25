package com.tsp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tsp.model.Product;
import com.tsp.repository.ProductRepository;


public class ProductDao {

	@Autowired
	private ProductRepository productRepository;

	
	public List<Product> getProductByName(String name) {
		return productRepository.findByName(name);
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	

}
