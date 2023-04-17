package com.demo.webapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.webapp.dto.ProductsDTO;
import com.demo.webapp.model.ProductsEntity;
import com.demo.webapp.service.ProductsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class ProductController {

	@Autowired
	private ProductsService productsService;
	

	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping("/addproducts")
	public void addProducts(@RequestBody ProductsDTO productsDto) {
		ProductsEntity products = ProductsEntity.builder()
				.name(productsDto.getName())
				.description(productsDto.getDescription())
				.price(productsDto.getPrice())
				.build();
		products = productsService.addProducts(products);		
	}
	
	
	
	@PreAuthorize("hasAuthority('Admin')")
	@DeleteMapping("/delete/product/{product_id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("product_id") int id){
		productsService.deleteProductById(id);
		return ResponseEntity.ok("Product number "+id + " Deleted");
	}
	
	@GetMapping("/getproducts/{product_id}")
	public Optional<ProductsEntity> getProduct(@PathVariable("product_id") int id) {
		return productsService.getProductById(id);
	}
}
