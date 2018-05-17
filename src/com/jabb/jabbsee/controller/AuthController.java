
package com.jabb.jabbsee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jabb.jabbsee.model.Library;
import com.jabb.jabbsee.model.User;
import com.jabb.jabbsee.repository.LibraryRepository;
import com.jabb.jabbsee.repository.UserRepository;

@RestController
public class AuthController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private LibraryRepository libraryRepo;
	
	//REGISTER USER
	@RequestMapping(value = "/register", 
			method = RequestMethod.POST, 
			consumes = "application/json")
	public void registerUser(@RequestBody User user) {		
		boolean added = userRepo.addUser(user);
		if(added == true) {
			Library library = new Library();
			library.setOwner(user.getUsername());
			libraryRepo.createLibrary(library);
		}
	}
	
	//DELETE USER
	@RequestMapping(value = "/user", 
			method = RequestMethod.DELETE, 
			consumes = "application/json")
	public void deleteUser(@RequestBody User user) {		
		userRepo.deleteUser(user);
	}
	
	//CHANGE PASSWORD
	@RequestMapping(value = "/user", 
			method = RequestMethod.POST, 
			consumes = "application/json")
	public void editUser(@RequestBody User user) {		
		userRepo.changePassword(user);
	}

}

