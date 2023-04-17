package com.demo.webapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.webapp.authenticationresponse.AuthenticationRequest;
import com.demo.webapp.authenticationresponse.AuthenticationResponse;
import com.demo.webapp.dto.RegisterDTO;
import com.demo.webapp.service.WebService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class WebController {

	@Autowired
	private WebService webService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/register/customer")
	public ResponseEntity<AuthenticationResponse> registerCustomer(@RequestBody RegisterDTO request)
	{
		return ResponseEntity.ok(webService.registerCustomer(request));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/register/admin")
	public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody RegisterDTO request)
	{
		return ResponseEntity.ok(webService.registerAdmin(request));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/authenticate/customer")
	public ResponseEntity<AuthenticationResponse> authenticateCustomer(@RequestBody AuthenticationRequest request)
	{
		return ResponseEntity.ok(webService.authenticateCustomer(request));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/authenticate/admin")
	public ResponseEntity<AuthenticationResponse> authenticateAdmin(@RequestBody AuthenticationRequest request)
	{
		return ResponseEntity.ok(webService.authenticateAdmin(request));
	}
	
}
