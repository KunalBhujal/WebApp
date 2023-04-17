package com.demo.webapp.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.webapp.converter.CustomerConverter;
import com.demo.webapp.dto.CustomerDTO;
import com.demo.webapp.model.WebEntity;
import com.demo.webapp.service.CustomerService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/login")
	public ResponseEntity<WebEntity> getUser(){
		WebEntity webEnt = customerService.getUserDetails();
		return ResponseEntity.ok(webEnt);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
		customerService.deleteEmployeeById(id);
		return ResponseEntity.ok("Deleted "+id);
	}
	@GetMapping("/getallcustomers")
	public List<CustomerDTO> getAllCustomers(){
		List<WebEntity> webEntity = customerService.getAllCustomers();
		List<CustomerDTO> customerList = CustomerConverter.convertCustomerDto(webEntity);
		return customerList;
	}

	
	@GetMapping("/getcustomer/{customer_id}")
	public List<CustomerDTO> getCustomersById(@PathVariable("customer_id") int customer_id){
		return customerService.getCustomersById(customer_id);
	}
}
