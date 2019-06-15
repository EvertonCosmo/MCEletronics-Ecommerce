package com.mceletronics.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mceletronics.api.model.User;
import com.mceletronics.api.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/MCEletronics/api")
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
		@GetMapping("/users")
		public List<User> listUsers(){
			return userRepository.findAll();
		}
		
		@GetMapping("/users/{id}")
		public User listSingleUser(@PathVariable(value="id") long id) {
			return userRepository.findById(id);
		}
		
		@PostMapping("/user")
		public User saveUsuer(@RequestBody @Valid User user) {
			return userRepository.save(user);
		}
		
		@DeleteMapping("/user")
		public void deleteUsuer(@RequestBody @Valid User user) {
			userRepository.delete(user);
		}
		
		@PutMapping("/user")
		public User updateUser(@RequestBody @Valid User user) {
			return userRepository.save(user);
		}
		
}
