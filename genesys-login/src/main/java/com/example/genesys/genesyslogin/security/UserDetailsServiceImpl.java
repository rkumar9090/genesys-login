package com.example.genesys.genesyslogin.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.genesys.genesyslogin.dao.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.example.genesys.genesyslogin.model.User genesysUser = userDao.findByUserName(username);

		if (genesysUser == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
		grantList.add(authority);

		UserDetails userDetails = (UserDetails) new User(genesysUser.getUserName(), //
				genesysUser.getPassword(), grantList);

		return userDetails;
	}

}
