package com.demo.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.webapp.model.WebEntity;
import com.demo.webapp.service.WebService;

@RequestMapping("/api")
@RestController
public class WebController {

	@Autowired
	private WebService webService;
	
	@RequestMapping("/user")
	public List<WebEntity> getAllUsers() 
	{
		return webService.getAllUsers();
	}
	
	@PreAuthorize("hasAuthority('ROLE_Admin')")
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public void createAdminUser(@RequestBody WebEntity webEntity) 
	{
		webService.createAdminUser(webEntity);
	}
	
	@RequestMapping("/customer/signup")
	public String customerSignup()
	{
		return "You have signed-up successfully";
	}
}
