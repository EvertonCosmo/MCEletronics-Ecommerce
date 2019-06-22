package com.mceletronics.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mceletronics.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
		
		@Query("FROM User WHERE username = ?1 AND password = ?2")
		User findUser(String username,String password);

		Optional<User> findByUsername(String username);

}
