package com.demo.webapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.webapp.model.ProductsEntity;
import com.demo.webapp.repository.ProductsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsService {

	@Autowired
	private ProductsRepository productsRepository;
	

	public ProductsEntity addProducts(ProductsEntity products) {
		return productsRepository.save(products);
		
	}
	
	public void deleteProductById(int id) {
		productsRepository.deleteById(id);
		
	}
	
	public Optional<ProductsEntity> getProductById(int id) {
		return productsRepository.findById(id);
	}
}
