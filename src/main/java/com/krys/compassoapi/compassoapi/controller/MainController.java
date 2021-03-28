package com.krys.compassoapi.compassoapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

	@GetMapping
	public ResponseEntity<?> getRoot() {
		return ResponseEntity.ok("Compasso-api is on ;)");
	}
	
}
