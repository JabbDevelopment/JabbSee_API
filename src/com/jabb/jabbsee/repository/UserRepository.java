package com.jabb.jabbsee.repository;

import com.jabb.jabbsee.model.User;

public interface UserRepository {
	public boolean validateUser(User user);
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public boolean changePassword(User user);
	public User getUser(String username);
}
