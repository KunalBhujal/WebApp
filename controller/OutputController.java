package com.demo.webapp.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OutputController {
	
	@RequestMapping("/api/customer/signup")
	public ResponseEntity<String> customerSignup()
	{
		return ResponseEntity.ok("You have signed-up successfully");
	}
	
}

