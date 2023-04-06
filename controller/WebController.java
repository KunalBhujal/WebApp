package com.demo.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.webapp.model.WebEntity;
import com.demo.webapp.productsentity.ProductsEntity;
import com.demo.webapp.service.WebService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class WebController {

	@Autowired
	private WebService webService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/register/customer")
	public ResponseEntity<AuthenticationResponse> registerCustomer(@RequestBody RegisterRequest request)
	{
		return ResponseEntity.ok(webService.registerCustomer(request));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/register/admin")
	public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody RegisterRequest request)
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
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
		webService.deleteEmployeeById(id);
		return ResponseEntity.ok("Deleted "+id);
	}
	
	@GetMapping("/login")
	public ResponseEntity<WebEntity> getUser(){
		WebEntity webEnt = webService.getUserDetails();
		return ResponseEntity.ok(webEnt);
	}
	
	
	@PreAuthorize("hasAuthority('Admin')")
	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public void addProducts(@RequestBody ProductsEntity prodEntity) {
		webService.addProducts(prodEntity);
	}

	
	//Order Products
	@PostMapping("/products/order")
	public ResponseEntity<?> orderProduct(@RequestBody ProductsEntity products,
					@RequestParam("token") String token){
		return null;
	}
	
	
	
	
	
	
	
	
//	@RequestMapping(method = RequestMethod.POSTee, value = "/product")
//	public void addProducts(@RequestBody ProductsEntity productsEntity) 
//	{
//		webService.addProducts(productsEntity);
//	}
	
	
//	@RequestMapping(method = RequestMethod.POST, value = "/user")
//	public void createAdminUser(@RequestBody WebEntity webEntity) 
//	{
//		webService.createAdminUser(webEntity);
//	}
}
