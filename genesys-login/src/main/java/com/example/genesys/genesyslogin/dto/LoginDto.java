package com.example.genesys.genesyslogin.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginDto {

	@Size(min = 3, max = 20, message = "name minimum should contain 3 char or maximum 20 chars")
	@NotNull(message = "username cannot be empty")
	private String username;
	
	@Size(min = 3, max = 20, message = "password minimum should contain 3 char or maximum 20 chars")
	@NotNull(message = "password cannot be empty")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
