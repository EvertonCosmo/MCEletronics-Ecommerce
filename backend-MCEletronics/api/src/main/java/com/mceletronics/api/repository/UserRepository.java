package com.mceletronics.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mceletronics.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
