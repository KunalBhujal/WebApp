package com.demo.webapp.dto;

import java.util.List;
import com.demo.webapp.model.ProductsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrderDTO {

	private int customer_id;
	private int id;
	private String name;
	private String description;
	private String price;
	private List<ProductsEntity> productsEntity;
}
