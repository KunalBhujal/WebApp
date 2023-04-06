package com.demo.webapp.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.demo.webapp.model.WebEntity;
import com.demo.webapp.repository.WebRepository;

@Component
public class GetUserInfoService implements UserDetailsService{

	@Autowired
	private WebRepository webRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<WebEntity> userInfo = webRepository.findByEmail(email);
		//System.out.println(userInfo);
		return userInfo.map(UserInfoDetails::new)
				.orElseThrow();
	}

}
