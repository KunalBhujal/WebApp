package com.demo.webapp.dto;

import java.util.List;

import com.demo.webapp.model.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

	private int customer_id;
	private String first_name;
	private List<OrderEntity> orderEntity;

}
