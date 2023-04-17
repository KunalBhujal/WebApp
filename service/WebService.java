package com.demo.webapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.webapp.authenticationresponse.AuthenticationRequest;
import com.demo.webapp.authenticationresponse.AuthenticationResponse;
import com.demo.webapp.dto.RegisterDTO;
import com.demo.webapp.model.WebEntity;
import com.demo.webapp.repository.WebRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WebService {
	
	@Autowired
	private WebRepository webRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	//Register user and Token
	public AuthenticationResponse registerCustomer(RegisterDTO request) {
		var customer = WebEntity.builder()
				.first_name(request.getFirst_name())
				.last_name(request.getLast_name())
				.email(request.getEmail())
				.pwd(passwordEncoder.encode(request.getPwd()))
				.role(request.getRole())
				.build();
		 webRepository.save(customer);
		var jwtTokenCustomer = jwtService.generateToken(customer);
		return AuthenticationResponse.builder()
				.token(jwtTokenCustomer)
				.build();
	}
	
	public AuthenticationResponse registerAdmin(RegisterDTO request) {
		var admin = WebEntity.builder()
				.first_name(request.getFirst_name())
				.last_name(request.getLast_name())
				.email(request.getEmail())
				.pwd(passwordEncoder.encode(request.getPwd()))
				.role(request.getRole())
				.build();
				
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
	
	

	

	

	
	


}
