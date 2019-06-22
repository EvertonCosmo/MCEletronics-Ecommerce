package com.mceletronics.api;

import java.util.Arrays;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mceletronics.api.config.CustomUserDetails;
import com.mceletronics.api.model.Role;
import com.mceletronics.api.model.User;
import com.mceletronics.api.repository.UserRepository;
import com.mceletronics.api.services.UserService;

@SpringBootApplication
public class ApiApplication {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	

	/**
	 * Password grants are switched on by injecting an AuthenticationManager.
	 * Here, we setup the builder so that the userDetailsService is the one we coded.
	 * @param builder
	 * @param repository
	 * @throws Exception
	 */
	
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService userService) throws Exception {
		if (repository.count()==0)
//			userService.saveUser(new User("admin", "adminPassword", Arrays.asList(new Role("USER"), new Role("ACTUATOR") , new Role("ADMIN"))));
			userService.saveUser(new User("admin","adminPassword","everton8cosmo@gmail","988288873","rua carlos batista","982389894239","Everton Cosmo","M",Arrays.asList(new Role("USER"), new Role("ACTUATOR") , new Role("ADMIN"))));
			builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
		
	}
	/**
	 * We return an instance of our CustomUserDetails.
	 * @param repository
	 * @return
	 */
	private UserDetailsService userDetailsService(final UserRepository repository) {
		return username -> new CustomUserDetails(repository.findByUsername(username));
	}

	
	
}
