package com.demo.webapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.webapp.model.ProductsEntity;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer>{

	
}
