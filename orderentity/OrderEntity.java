//package com.demo.webapp.orderentity;
//
//import com.demo.webapp.model.WebEntity;
//import com.demo.webapp.productsentity.ProductsEntity;
//
//import jakarta.annotation.Generated;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "Order Table")
//public class OrderEntity {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private String id;
//	
//	@OneToMany(targetEntity = WebEntity.class, fetch = FetchType.EAGER)
//	@JoinColumn(name = "customer_id")
//	private WebEntity webEntity;
//	
//	@ManyToOne 
//	@JoinColumn(name = "product_id")
//	private ProductsEntity productsEntity;
//}
