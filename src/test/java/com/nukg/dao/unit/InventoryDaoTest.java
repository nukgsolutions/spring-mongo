package com.nukg.dao.unit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nukg.model.Inventory;
import com.nukg.model.Product;


@RunWith(SpringJUnit4ClassRunner.class)
public class InventoryDaoTest extends BaseUnitTester {

	
	
	@Test
	public void testAddProduct() throws Exception {
		
		// Add one Inventory record before testing
		Product product1 = new Product();
		product1.setName("Mac Book Air");
		product1.setType("Electronics");
		product1 = productDao.saveProduct(product1);
		
		String[] products = new String[1];
		products[0] = product1.getId();
		Inventory inventory = new Inventory();
		inventory.setProducts(products);
		inventory = inventoryDao.saveInventory(inventory);
		
		// Add another product to product collection first
		Product product2 = new Product();
		product2.setName("Iphone");
		product2.setType("Electronics");
		product2 = productDao.saveProduct(product2);
		
		// Push second product to inventory
		inventoryDao.addProduct(inventory.getId(), product2.getId());
		
		// Retrieve the updated inventory
		inventory = inventoryDao.getInventory(inventory.getId());
		
		// Assert, We should have two products in inventory
		assertEquals(2, inventory.getProducts().length);
		
		// Once the test is done, remove the inventory
		inventoryDao.deleteInventory(inventory);
		
				
	}
	
	@Test
	public void testRemoveProduct() throws Exception {
		
		// Add one Inventory record, with two products before testing
		Product product1 = new Product();
		product1.setName("Mac Book Air");
		product1.setType("Electronics");
		product1 = productDao.saveProduct(product1);
		
		Product product2 = new Product();
		product2.setName("Iphone");
		product2.setType("Electronics");
		product2 = productDao.saveProduct(product2);
				
		String[] products = new String[2];
		products[0] = product1.getId();
		products[1] = product2.getId();
		Inventory inventory = new Inventory();
		inventory.setProducts(products);
		inventory = inventoryDao.saveInventory(inventory);
		
		// We should have two products in inventory
		assertEquals(2, inventory.getProducts().length);
		
		// pull one product from inventory
		inventoryDao.removeProduct(inventory.getId(), product1.getId());
		
		// retrieve the updated inventory
		inventory = inventoryDao.getInventory(inventory.getId());
		
		// We should have only one product in the inventory
		assertEquals(1, inventory.getProducts().length);
		
		// Once the test is done, remove the inventory
		inventoryDao.deleteInventory(inventory);
						
	}
	


	

}