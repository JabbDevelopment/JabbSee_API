package com.jabb.jabbsee.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	//private final String USER = "userRole";
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
	
	@Override
	public User getUser(String username) {
		Query query = Query.query(Criteria.where(USERNAME_VAR).is(username));
		User userFromDB = mongoTemplate.findOne(query, User.class, COLLECTION_NAME);
		return userFromDB;
	}
	
	/*@Override
	public boolean validateUser(User user) {
		User userFromDB = getUser(user.getUsername());
		
		if(userFromDB == null) {
			return false;
		}
		boolean matches = encoder.matches(user.getPassword(), userFromDB.getPassword());
		System.out.println("In validateUser. Matches password: " + matches);
		System.out.println("\n In validateUser. "
				+ "User-Password: " +user.getPassword() 
				+ "DB-Password: " +userFromDB.getPassword());
		
		return matches;	
	}*/

	@Override
	public boolean addUser(User user) {
		User userFromDB = getUser(user.getUsername());	
		if(userFromDB != null) {
			return false;
		}
			
		String result = encoder.encode(user.getPassword());
		
		System.out.println("Encoded password: " + result);
		
		/*List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

	    user.setGrantedAuthorities(grantedAuthorities);*/
		
		user.setPassword(result);
		
		mongoTemplate.insert(user, COLLECTION_NAME);
			
		User addedUser = getUser(user.getUsername());
			
		return addedUser != null;
	}

	@Override
	public boolean deleteUser(User user) {		
		Query query = Query.query(Criteria.where(USERNAME_VAR).is(user.getUsername()));
		mongoTemplate.remove(query, Library.class, COLLECTION_NAME);
		return true;
	}

	@Override
	public boolean changePassword(User user) {
		Query query = Query.query(Criteria.where(USERNAME_VAR).is(user.getUsername()));
		Update update = new Update().set(PASSWORD_VAR, user.getPassword());
		mongoTemplate.updateFirst(query, update, COLLECTION_NAME);
		User updatedUser = mongoTemplate.findOne(query, User.class, COLLECTION_NAME);
		if(updatedUser != null)
			return true;
		return false;
	}


	

}

