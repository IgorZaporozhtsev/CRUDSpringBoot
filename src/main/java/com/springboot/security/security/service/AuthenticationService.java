/*
package com.springboot.security.security.service;

import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	UserService userService;

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userService.getUserByLogin(login);
		if (user == null) {
			throw new UsernameNotFoundException("Login " + login + " not found");
		}
		return user;
	}
}
*/
