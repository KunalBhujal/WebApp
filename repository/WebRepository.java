package com.demo.webapp.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.webapp.model.WebEntity;

@Repository
public interface WebRepository extends JpaRepository<WebEntity, Integer>{

	Optional<WebEntity> findByEmail(String email);
}