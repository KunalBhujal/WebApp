package com.demo.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.webapp.model.WebEntity;

public interface WebRepository extends JpaRepository<WebEntity, String>{

}
