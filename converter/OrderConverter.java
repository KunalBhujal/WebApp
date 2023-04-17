package com.demo.webapp.converter;

import java.util.ArrayList;
import java.util.List;

import com.demo.webapp.dto.CustomerOrderDTO;
import com.demo.webapp.model.OrderEntity;

public class OrderConverter {

	public static List<CustomerOrderDTO> convertToDtoList(List<OrderEntity> orderEntity){
		List<CustomerOrderDTO> customerOrder = new ArrayList<>();
		for(OrderEntity order: orderEntity) {
			CustomerOrderDTO customerOrderDto = new CustomerOrderDTO();
			customerOrderDto.setCustomer_id(order.getWebEntity().getCustomer_id());
			customerOrderDto.setId(order.getId());
			customerOrderDto.setName(order.getName());
			customerOrderDto.setDescription(order.getDescription());
			customerOrderDto.setPrice(order.getPrice());
			customerOrderDto.setProductsEntity(order.getProductsEntity());
			
			customerOrder.add(customerOrderDto);
		}
		return customerOrder;
	}
}
