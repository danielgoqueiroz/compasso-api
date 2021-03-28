package com.krys.compassoapi.compassoapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krys.compassoapi.compassoapi.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
		
	List<User> users = new ArrayList<User>();
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<?> save(@RequestBody User user) {
		
		validate(user);
		addUser(user);
		
		return ResponseEntity.ok(user) ;
	}
	
	private void addUser(User user) {
		long id = new Random().nextLong();
		user.setId(id < 0 ? id * -1 : id);
		users.add(user);
	}

	private void validate(User user) {
		// TODO Auto-generated method stub
		
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<?> getArtists() {
		
		return ResponseEntity.ok(users);
	}
	

}
