package com.demo.webapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.webapp.converter.OrderConverter;
import com.demo.webapp.dto.CustomerOrderDTO;
import com.demo.webapp.dto.OrderDTO;
import com.demo.webapp.dto.ResponseOrderDTO;
import com.demo.webapp.model.OrderEntity;
import com.demo.webapp.model.ProductsEntity;
import com.demo.webapp.model.WebEntity;
import com.demo.webapp.repository.ProductsRepository;
import com.demo.webapp.service.OrdersService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class OrdersController {

	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private OrdersService ordersService;
	
	
	//Original Method
	@GetMapping("/getorders/{id}")
	public List<CustomerOrderDTO> getOrdersById(@PathVariable("id") int id){
		return ordersService.getOrdersById(id);
	}
	

	
	@PreAuthorize("hasAuthority('Admin')")
	@GetMapping("/getallorders")
	public List<CustomerOrderDTO> getAllOrders(){
		List<OrderEntity> orderEntity = ordersService.getAllOrders();
		List<CustomerOrderDTO> customerOrder = OrderConverter.convertToDtoList(orderEntity);
		return customerOrder;
	}
	
	@PostMapping("/products/order")
	public ResponseEntity<ResponseOrderDTO> buyProducts(@RequestBody OrderDTO orderDTO){
		ResponseOrderDTO responseOrder = new ResponseOrderDTO();
		
		WebEntity webEntity = new WebEntity();
		webEntity = (WebEntity)SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getPrincipal();
		
		List<ProductsEntity> productsL = new ArrayList<>();
		for(Integer id : orderDTO.getProductsId()) {
			Optional<ProductsEntity> product = productsRepository.findById(id);
			if(product.isPresent()) {
				productsL.add(product.get());
			}
		}
		OrderEntity order = OrderEntity
				.builder()
				.name(orderDTO.getName())
				.description(orderDTO.getDescription())
				.price(orderDTO.getPrice())
				.webEntity(webEntity)
				.productsEntity(productsL)
				.build();
		
		order = ordersService.orderProducts(order); 
		
		List<OrderEntity> orderList = new ArrayList<>();
		orderList.add(order);
		
		webEntity.setOrderEntity(orderList);
		
		responseOrder.setName(orderDTO.getName());
		responseOrder.setDescription(orderDTO.getDescription());
		responseOrder.setPrice(orderDTO.getPrice());
		
		return ResponseEntity.ok(responseOrder);
	}
}
