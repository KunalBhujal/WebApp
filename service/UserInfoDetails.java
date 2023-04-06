package com.demo.webapp.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.webapp.model.Type;
import com.demo.webapp.model.WebEntity;




public class UserInfoDetails implements UserDetails{
	
	private String email;
	private String firstname;
	private String lastname;
	private String pwd;
	private String authorities;
	
	
	public UserInfoDetails(WebEntity webEntity) {
		email = webEntity.getEmail();
		pwd = webEntity.getPwd();
		firstname = webEntity.getFirst_name();
		lastname = webEntity.getLast_name();
		authorities = webEntity.getRole();
	}
	
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(authorities));
	}

	@Override
	public String getPassword() {
		return pwd;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	

}
