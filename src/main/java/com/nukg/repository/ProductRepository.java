package com.nukg.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nukg.model.Product;

/**
 * @author smondi
 *
 */
public interface ProductRepository extends MongoRepository<Product, String> {

	List<Product> findByName(String name);
	List<Product> findByType(String type);


}
