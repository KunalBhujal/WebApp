package com.demo.webapp.converter;

import java.util.ArrayList;
import java.util.List;

import com.demo.webapp.dto.CustomerDTO;
import com.demo.webapp.model.WebEntity;

public class CustomerConverter {

	public static List<CustomerDTO> convertCustomerDto(List<WebEntity> webEntity){
		List<CustomerDTO> customerDto = new ArrayList<>();
		for(WebEntity object:webEntity) {
				CustomerDTO dtoObject = new CustomerDTO();
				dtoObject.setCustomer_id(object.getCustomer_id());
				dtoObject.setFirst_name(object.getFirst_name());
				dtoObject.setOrderEntity(object.getOrderEntity());

				
				customerDto.add(dtoObject);
		}
		return customerDto;
	}
}
