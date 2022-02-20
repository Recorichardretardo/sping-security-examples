package com.example.basic.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecurityController {
	
	@GetMapping("test")
	public String getTest() {
		return "Hello World!!!";
	}
	
	@GetMapping("test-second")
	public String getTestSecond() {
		return "Second Hello World!!!";
	}
	
	@GetMapping("test-third")
	public String getTestThird() {
		return "Third Hello World!!!";
	}

	@GetMapping("test-fourth")
	public String getTestFourth() {
		return "Fourth Hello World!!!";
	}
	
	@GetMapping("test-fifth")
	public String getTestFive() {
		return "Fifth Hello World!!!";
	}
	
}
