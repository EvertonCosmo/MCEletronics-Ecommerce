package com.mceletronics.api.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mceletronics.api.model.User;
import com.mceletronics.api.repository.UserRepository;

import ch.qos.logback.core.status.Status;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/MCEletronics/api")
public class UserService {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {

		return new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK);
	}
	
	

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable(value = "id") Integer id) {

		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(User user){
		User user1 = userRepository.findUser(user.getUsername(),user.getPassword());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		System.out.println(user1);
		if(user1 != null) {
			System.out.println(user);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(String username, String password, String email, String phone, String adress,
			String cpf, String nameComplete, String sexo) {

		if (username == null || password == null || username.equals("null") || password.equals("null")) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<User> userAux = userRepository.findByUsername(username);
		System.out.println("aux:" + userAux);
		if(userAux.isPresent()) {
			System.out.println("equals");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // 401	
		}
		
		User user = new User(username, password, null,null, null, null, null, null);
		userRepository.save(user);

		return new ResponseEntity<User>(user, HttpStatus.OK);
		

		

	}

//	@DeleteMapping("/user")
//	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer id) {
//
//		if (userRepository.existsById(id)) {
//
//			userRepository.deleteById(id);
//
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//		} else {
//
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, String username, String password,
			String email, String phone, String adress, String cpf, String nameComplete, String sexo) {

		if (username == null || password == null || email == null || phone == null || adress == null || cpf == null
				|| nameComplete == null || sexo == null || username.equals("null") || password.equals("null")
				|| email.equals("null") || phone.equals("null") || adress.equals("null") || cpf.equals("null")
				|| nameComplete.equals("null") || sexo.equals("null")) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {
			user.get().setUsername(username);
			user.get().setPassword(password);
			user.get().setEmail(email);
			user.get().setPhone(phone);
			user.get().setAdress(adress);
			user.get().setCpf(cpf);
			user.get().setNameComplete(nameComplete);
			user.get().setSexo(sexo);

			userRepository.save(user.get());

			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
