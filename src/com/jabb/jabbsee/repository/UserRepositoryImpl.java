package com.jabb.jabbsee.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.jabb.jabbsee.model.Library;
import com.jabb.jabbsee.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	private final String COLLECTION_NAME = "userCollection";
	private final String USERNAME_VAR = "username";
	private final String PASSWORD_VAR = "password";
	
	@Override
	public boolean validateUser(User user) {
		/*Query query = Query.query(Criteria.where(USERNAME_VAR).is(user.getUsername()));
		User userFromDB = mongoTemplate.findOne(query, User.class, COLLECTION_NAME);
		if(userFromDB.getPassword().equals(user.getPassword()))
			return true;
		else
			return false;*/
		Query query = Query.query(Criteria.where(USERNAME_VAR).is(user.getUsername()).
				and(PASSWORD_VAR).is(user.getPassword()));
		User userFromDB = mongoTemplate.findOne(query, User.class, COLLECTION_NAME);
		if(userFromDB != null)
			return true;
		else
			return false;
		
	}

	@Override
	public boolean addUser(User user) {
		if(validateUser(user) == true)
			return false;
		mongoTemplate.insert(user, COLLECTION_NAME);
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		if(validateUser(user) == false)
			return false;
		
		Query query = Query.query(Criteria.where(USERNAME_VAR).is(user.getUsername()));
		mongoTemplate.remove(query, Library.class, COLLECTION_NAME);
		return true;
	}

	@Override
	public boolean changePassword(User user) {
		if(validateUser(user) == false)
			return false;	
		
		Query query = Query.query(Criteria.where(USERNAME_VAR).is(user.getUsername()));
		Update update = new Update().set(PASSWORD_VAR, user.getPassword());
		mongoTemplate.updateFirst(query, update, COLLECTION_NAME);
		User updatedUser = mongoTemplate.findOne(query, User.class, COLLECTION_NAME);
		if(updatedUser != null)
			return true;
		return false;
	}
	

}

