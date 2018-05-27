package com.jabb.jabbsee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jabb.jabbsee.model.User;
import com.jabb.jabbsee.model.UserAuthDetail;
import com.jabb.jabbsee.repository.UserRepository;

@Component
public class UserAuthService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.getUser(username);	
        if(user == null) {
            throw new UsernameNotFoundException(username);
        } else {
        	System.out.println("UserAuthService. loadUserByUsername. Username: " + user.getUsername() + " Password: " + user.getPassword());
            UserDetails details = new UserAuthDetail(user);
            System.out.println("loadUserByUsername: "+ details);
            return details;
        }
	}

}
