package com.demo.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

	private String email;
	private String first_name;
	private String last_name;
	private String pwd;
	private String role;
}
