package com.demo.webapp.dto;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	
	
	private String name;
	private String description;
	private String price;
	
	private List<Integer> productsId;
	
	
}
	
