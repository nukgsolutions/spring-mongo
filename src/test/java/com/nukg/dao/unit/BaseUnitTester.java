package com.nukg.dao.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nukg.dao.InventoryDao;
import com.nukg.dao.ProductDao;
import com.nukg.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({ "web" })
@ContextConfiguration(locations = {
		"file:src/main/resources/all-beans-spring.xml",
		"file:src/main/resources/mongo-config.xml" })
public abstract class BaseUnitTester {

	@Autowired
	protected ProductDao productDao;

	@Autowired
	protected InventoryDao inventoryDao;
	
	@Autowired
	protected UserDao userDao;

	@Before
	public void setUp() {

	}

	@After
	public void anythingAfter() {

	}

}
