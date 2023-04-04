package com.greatlearning.srs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.greatlearning.srs.entity.User;
import com.greatlearning.srs.repository.UserRepository;
import com.greatlearning.srs.security.MyCustomUserDetails;

@Repository
public class StudentUserDetailsService
	implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		
		User userEntity = userRepository.getUserByUsername(username);
		
		if (userEntity == null) {
			// Throw exception
			throw new UsernameNotFoundException("Could not find user");
		}
		
		return new MyCustomUserDetails(userEntity);
	}

}