package com.jabb.jabbsee.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserAuthDetail implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	public UserAuthDetail(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("UserAuthDetail: getAuthorities()");
		return null;
	}

	@Override
	public String getPassword() {
		System.out.println("UserAuthDetail PW: "+ user.getPassword());
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		System.out.println("UserAuthDetail USER: "+ user.getUsername());
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		System.out.println("UserAuthDetail: isAccountNonExpired()");
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		System.out.println("UserAuthDetail: isAccountNonLocked()");
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		System.out.println("UserAuthDetail: isCredentialsNonExpired()");
		return true;
	}

	@Override
	public boolean isEnabled() {
		System.out.println("UserAuthDetail: isEnabled()");
		return true;
	}

}
