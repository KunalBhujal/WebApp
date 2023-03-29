package com.demo.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.webapp.model.WebEntity;
import com.demo.webapp.repository.WebRepository;

@Service
public class WebService {
	
	@Autowired
	private WebRepository webRepository;

	public void createAdminUser(WebEntity webEntity) {
		webRepository.save(webEntity);
		
	}

	public List<WebEntity> getAllUsers() {
		List<WebEntity> users = new ArrayList<>();
		webRepository.findAll().forEach(users::add);
		return users;
		
	}

}
