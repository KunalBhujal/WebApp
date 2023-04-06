package com.demo.webapp.outputcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.webapp.model.Type;
import com.demo.webapp.model.WebEntity;
import com.demo.webapp.productsentity.ProductsEntity;
import com.demo.webapp.productsregister.ProductsRegister;
import com.demo.webapp.productsrepository.ProductsRepository;
import com.demo.webapp.repository.WebRepository;
import com.demo.webapp.service.UserInfoDetails;
import com.demo.webapp.service.WebService;

@RestController
//@RequestMapping("/api/customer/signup")
public class OutputController {

	
	@Autowired
	private ProductsRepository prodRepository;
	
	@Autowired
	private WebRepository webRepository;

	@Autowired
	private WebService webService;
	
	@RequestMapping("/api/customer/signup")
	public ResponseEntity<String> customerSignup()
	{
		return ResponseEntity.ok("You have signed-up successfully");
	}
	
	
	
	
	
	

	
	
	
	
//	@RequestMapping(method = RequestMethod.GET, value = "/api/login")
//	public String getUser(@RequestBody UserInfoDetails userInfoDetails) {
//		return webService.getUser(userInfoDetails);
//	}
//	
		
	}

