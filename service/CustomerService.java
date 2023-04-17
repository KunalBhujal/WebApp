package com.demo.webapp.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.demo.webapp.dto.CustomerDTO;
import com.demo.webapp.model.WebEntity;
import com.demo.webapp.repository.WebRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

	@Autowired
	private WebRepository webRepository;
	

	
	public WebEntity getUserDetails() {
		return  (WebEntity)SecurityContextHolder
				.getContext()
				.getAuthentication().getPrincipal();
	}
	
	public void deleteEmployeeById(int id) {
	      webRepository.deleteById(id);
	   }

	public List<WebEntity> getAllCustomers() {
		return webRepository.findAll();
	}

	public List<CustomerDTO> getCustomersById(int customer_id) {
		return webRepository.findById(customer_id)
				.stream()
				.map(this::convertCustomerToDto)
				.collect(Collectors.toList());
	}

	private CustomerDTO convertCustomerToDto(WebEntity webEntity) {
		CustomerDTO customerDto = new CustomerDTO();
		customerDto.setCustomer_id(webEntity.getCustomer_id());
		customerDto.setFirst_name(webEntity.getFirst_name());
		customerDto.setOrderEntity(webEntity.getOrderEntity());
		
		return customerDto;
	}
	
}
