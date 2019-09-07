package com.example.genesys.genesyslogin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.genesys.genesyslogin.dto.LoginDto;
import com.example.genesys.genesyslogin.service.LoginService;

/**
 * Login controller for login operation
 * 
 * @author RAJESH
 *
 */
@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * login will compare username and password and persist login time as currect
	 * system time
	 * 
	 * @param loginDto
	 * @return Success
	 * @exception HttpStatus.UNAUTHORIZED
	 */
	@PostMapping
	public String login(@Valid @RequestBody LoginDto loginDto) {
		return loginService.loginService(loginDto);

	}

}
