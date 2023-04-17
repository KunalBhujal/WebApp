package com.demo.webapp.service;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.webapp.dto.CustomerOrderDTO;
import com.demo.webapp.model.OrderEntity;
import com.demo.webapp.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdersService {

	@Autowired
	private OrderRepository orderRepository;
	
	public OrderEntity orderProducts(OrderEntity order) {
		return orderRepository.save(order);
	}

	public List<OrderEntity> getAllOrders() {
		return orderRepository.findAll();
	}


	
	
	public List<CustomerOrderDTO> getOrdersById(int id) {
		return orderRepository.findById(id)
				.stream()
				.map(this::convertEntityDto)
				.collect(Collectors.toList());
		
	}

	private CustomerOrderDTO convertEntityDto(OrderEntity orderEntity) {
		CustomerOrderDTO orderDto = new CustomerOrderDTO();
		orderDto.setCustomer_id(orderEntity.getWebEntity().getCustomer_id());
		orderDto.setId(orderEntity.getId());
		orderDto.setName(orderEntity.getName());
		orderDto.setDescription(orderEntity.getDescription());
		orderDto.setPrice(orderEntity.getPrice());
		orderDto.setProductsEntity(orderEntity.getProductsEntity());
		
		return orderDto;
	}



	

	
}
