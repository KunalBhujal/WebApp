package com.demo.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.webapp.controller.AuthenticationRequest;
import com.demo.webapp.controller.AuthenticationResponse;
import com.demo.webapp.controller.RegisterRequest;
import com.demo.webapp.jwtservice.JwtService;
import com.demo.webapp.model.Type;
import com.demo.webapp.model.WebEntity;
import com.demo.webapp.productsentity.ProductsEntity;
import com.demo.webapp.productsrepository.ProductsRepository;
import com.demo.webapp.repository.WebRepository;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Service
//@Builder
@RequiredArgsConstructor
public class WebService {
	
	@Autowired
	private WebRepository webRepository;
	
	@Autowired
	private ProductsRepository prodRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	//Register user and Token
	public AuthenticationResponse registerCustomer(RegisterRequest request) {
		var customer = WebEntity.builder()
				.first_name(request.getFirst_name())
				.last_name(request.getLast_name())
				.email(request.getEmail())
				.pwd(passwordEncoder.encode(request.getPwd()))
				.role(request.getRole())
				//.type(Type.Customer)
				.build();
		 webRepository.save(customer);
		var jwtTokenCustomer = jwtService.generateToken(customer);
		return AuthenticationResponse.builder()
				.token(jwtTokenCustomer)
				.build();
	}
	
	public AuthenticationResponse registerAdmin(RegisterRequest request) {
		var admin = WebEntity.builder()
				.first_name(request.getFirst_name())
				.last_name(request.getLast_name())
				.email(request.getEmail())
				.pwd(passwordEncoder.encode(request.getPwd()))
				.role(request.getRole())
				.build();
				//.type(Type.Admin)
				
		 webRepository.save(admin);
		var jwtTokenAdmin = jwtService.generateToken(admin);
		return AuthenticationResponse.builder()
				.token(jwtTokenAdmin)
				.build();
	}

	
	//Authenticating user and sending back token
	public AuthenticationResponse authenticateCustomer(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), 
						request.getPwd()));
		
		var customer = webRepository.findByEmail(request.getEmail()).orElseThrow(); 
		var jwtTokenCustomer = jwtService.generateToken(customer);
		 
		
		return AuthenticationResponse.builder()
				.token(jwtTokenCustomer)
				.build();
	}

	public AuthenticationResponse authenticateAdmin(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), 
						request.getPwd()));
		
		var admin = webRepository.findByEmail(request.getEmail()).orElseThrow(); 
		var jwtTokenAdmin = jwtService.generateToken(admin);
		 
		
		return AuthenticationResponse.builder()
				.token(jwtTokenAdmin)
				.build();
	}
	
	
	public void deleteEmployeeById(int id) {
	      webRepository.deleteById(id);
	   }

	public String addProducts(ProductsEntity prodEntity) {
		prodRepository.save(prodEntity);
		return "Product added successfully! ";
		
	}

	public WebEntity getUserDetails() {
		//webRepository.findByEmail(email);
		return  (WebEntity)SecurityContextHolder
				.getContext()
				.getAuthentication().getPrincipal();
	}

	
//	public String getUser(UserInfoDetails userInfoDetails) {
//		webRepository.getByEmail(userInfoDetails);
//		return null;
//	}

	

	
//	public void addProducts(ProductsEntity productsEntity) 
//	{
//		prodRepository.save(productsEntity);
//	}

	
	
//	public void createAdminUser(WebEntity webEntity) {
//		webRepository.save(webEntity);
//		
//	}

}
