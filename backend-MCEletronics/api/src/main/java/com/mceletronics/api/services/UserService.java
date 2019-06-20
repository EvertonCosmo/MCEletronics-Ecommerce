package com.mceletronics.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mceletronics.api.model.User;
import com.mceletronics.api.repository.UserRepository;
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public void saveUser (User user) {
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		userRepository.save(user);
		
	}
	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}
	public Optional<User> getUserById(Integer id) {
		return userRepository.findById(id);
	}
	
	
}
