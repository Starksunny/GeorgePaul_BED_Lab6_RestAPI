package com.greatlearning.srs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.srs.entity.User;

public interface UserRepository 
	extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u WHERE u.username = ?1")
	User getUserByUsername(String username);
}
