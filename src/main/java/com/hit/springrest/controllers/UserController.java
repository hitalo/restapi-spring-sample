package com.hit.springrest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hit.springrest.model.User;
import com.hit.springrest.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	
	@PutMapping
	public User updateUser(@RequestBody User user) {
		Optional<User> optionalUser = userRepository.findById(user.getId());
		if(optionalUser.isPresent()) return userRepository.save(user);
		else throw new RuntimeException("User not found with id: " + user.getId());
	}
	
	
	@DeleteMapping("/delete-user")
	public User delete(@RequestBody User user) {			
		Optional<User> optionalUser = userRepository.findById(user.getId());
		if(optionalUser.isPresent()) userRepository.delete(optionalUser.get());
		else throw new RuntimeException("User not found with id: " + user.getId());
		return optionalUser.get();
	}			
	
	
	@GetMapping("/test")
	public String test() {
		
		User user = new User();
		user.setName("José");
		System.out.println(new Gson().toJson(user));
		
		return "test";
	}
}
