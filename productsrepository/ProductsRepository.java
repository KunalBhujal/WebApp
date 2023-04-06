package com.demo.webapp.productsrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.webapp.productsentity.ProductsEntity;

public interface ProductsRepository extends JpaRepository<ProductsEntity, String>{

}
