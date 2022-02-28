package com.swagger.openapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Home page")
@RestController
@RequestMapping("/api")
public class OpenApiController {
	
	@GetMapping("/get-test")
	public String getTest() {
		return "get-test";
	}
	
	@GetMapping("/get-test/one")
	public String getTestOne() {
		return "get-test-one";
	}
	
	
	@GetMapping("/get-test-two")
	public String getTestTwo() {
		return "get-test-two";
	}
	
	@GetMapping("/get-test-three")
	public String getTestThree() {
		return "get-test-two";
	}

}
