package com.demo.webapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.demo.webapp.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

	
}
 