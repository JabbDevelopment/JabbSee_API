package com.jabb.jabbsee.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.jabb.jabbsee.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public boolean validateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}

