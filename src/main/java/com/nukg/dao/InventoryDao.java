package com.tsp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.tsp.model.Inventory;
import com.tsp.repository.InventoryRepository;


public class InventoryDao {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	
	public Inventory saveInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}
	
	public void deleteInventory(Inventory inventory) {
		 inventoryRepository.delete(inventory);
	}
	
	public Inventory getInventory(String id) {
		return inventoryRepository.findOne(id);
	}
	
	public void addProduct(String inventoryId, String  productId) {
		mongoTemplate.updateFirst(Query.query(Criteria.where("id").is(inventoryId)),
				new Update().push("products", productId), Inventory.class);
	}
	
	public void removeProduct(String inventoryId, String  productId) {
		mongoTemplate.updateFirst(Query.query(Criteria.where("id").is(inventoryId)),
				new Update().pull("products", productId), Inventory.class);
	}


}
