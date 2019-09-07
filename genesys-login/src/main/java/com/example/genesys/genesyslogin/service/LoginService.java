package com.example.genesys.genesyslogin.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.genesys.genesyslogin.dao.UserDao;
import com.example.genesys.genesyslogin.dto.LoginDto;
import com.example.genesys.genesyslogin.model.User;

@Component
public class LoginService {

	@Autowired
	private UserDao userDao;

	public String loginService(LoginDto loginDto) {

		User user = userDao.findByUserName(loginDto.getUsername());
		if (null != user) {
			if (loginDto.getPassword().equals(user.getPassword())) {
				user.setLastlogin(new Date());
				userDao.save(user);
				return "SUCCESS";
			} else {
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username and password");
			}
		} else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username is not valid");
		}

	}

}
