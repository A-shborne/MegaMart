package com.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "confirm_password")
	private String cnfPassword;
	@Column(name = "email")
	private String email;
	
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
	public String getCnfPassword() {
		return cnfPassword;
	}
	public void setCnfPassword(String cnfPassword) {
		this.cnfPassword = cnfPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
		
	
	

}
