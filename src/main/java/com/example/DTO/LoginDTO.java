package com.example.DTO;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {
	
	@NotBlank
	private String name;
	@NotBlank
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
