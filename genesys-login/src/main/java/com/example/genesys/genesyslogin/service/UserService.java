package com.example.genesys.genesyslogin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.genesys.genesyslogin.dao.UserDao;
import com.example.genesys.genesyslogin.dto.UserDto;
import com.example.genesys.genesyslogin.model.User;

@Component
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> getAllUser() {
		return userDao.findAll();
	}

	public User getUser(int id) {
		Optional<User> user = userDao.findById(id);
		if (user.isPresent()) {
			return userDao.findById(id).get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not exists");
		}
	}

	public void deleteUser(int id) {
		userDao.deleteById(id);
	}

	public void addUser(UserDto userDto) {
		User userExists = userDao.findByUserName(userDto.getName());
		if (null == userExists) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			User user = new User();
			user.setUserName(userDto.getName());
			user.setPassword(encoder.encode(userDto.getPassword()));
			user.setEmail(userDto.getEmail());
			userDao.save(user);
		} else {
			throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "Username already exists");
		}
	}

	public void update(UserDto userDto) {
		if (userDto.getId() > 0) {
			Optional<User> userValue = userDao.findById(userDto.getId());
			if (userValue.isPresent()) {
				User user = userValue.get();
				user.setUserName(userDto.getName());
				user.setPassword(userDto.getPassword());
				user.setEmail(userDto.getEmail());
				userDao.save(user);
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not exists");
			}
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id is not valid");
		}

	}

}
