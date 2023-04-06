package com.demo.webapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.webapp.controller.AuthenticationResponse;
import com.demo.webapp.model.WebEntity;
import com.demo.webapp.service.UserInfoDetails;

@Repository
public interface WebRepository extends JpaRepository<WebEntity, Integer>{

	Optional<WebEntity> findByEmail(String email);
	//AuthenticationResponse findByToken(String token);
}