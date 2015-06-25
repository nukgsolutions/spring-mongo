package com.nukg.dao.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nukg.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest extends BaseUnitTester {

	@Test
	public void testAddCredit() throws Exception {

		User user = userDao.getUserByName("Stevens");

		if (user == null) { // Create one user for testing, if 'Stevens' doesn't
							// exist.
			user = new User();
			user.setName("Stevens");
			user.setStatus("ACTIVE");
			user.setScore(5);
			userDao.saveUser(user);
		}

		int originalScore = user.getScore();

		// Retrieve saved user to check correct score
		User savedUser = userDao.getUser(user.getId());
		assertEquals(savedUser.getScore(), originalScore);

		// add more 5 more score
		userDao.addScore(savedUser.getId(), 5);

		int updatedScore = originalScore + 5;

		// Retrieve the user
		User userWithMoreScore = userDao.getUser(user.getId());
		assertEquals(userWithMoreScore.getScore(), updatedScore);

	}

}