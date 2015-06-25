package com.nukg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nukg.model.Inventory;


public interface InventoryRepository extends MongoRepository<Inventory, String> {

}
