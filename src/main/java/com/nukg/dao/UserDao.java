package com.nukg.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.nukg.model.User;

public class UserDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void addScore(String userid, int score) {

		Query query = Query.query(Criteria.where("id").is(userid)
				.andOperator(Criteria.where("status").is("ACTIVE")));

		mongoTemplate.findAndModify(query,
				new Update().inc("score", score), User.class);

	}

	public void saveUser(User user) {
		mongoTemplate.save(user);
	}

	public User getUser(String id) {
		return mongoTemplate.findById(id, User.class);
	}
	
	public User getUserByName(String name) {
		Query query = Query.query(Criteria.where("name").is(name));
		return mongoTemplate.findOne(query, User.class);
	}

}
