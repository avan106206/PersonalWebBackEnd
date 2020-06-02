package com.webBackEnd.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webBackEnd.dao.RoleRepository;
import com.webBackEnd.dao.UserRepository;
import com.webBackEnd.entity.Role;
import com.webBackEnd.entity.User;

@Service
public class UserServiceInterfaceImplementation implements UserServiceInterface{

	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword())); //Encode the password
		user.setStatus("VERIFIED"); //set user VERIFIED
		Role userRole = roleRepository.findByRole("SITE_USER"); //find all object of SITE_USER
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole))); //set the role as a SITE_USER
		userRepository.save(user);
	}

	@Override
	public boolean isUserAlreadyPresent(User user) {
		List<User> userlist = userRepository.findAll();
		for(User userset: userlist) {
			if(userset.getEmail().contains(user.getEmail()) )	return true;
		}
		return false;
	}// here I implement the interface of AuthenticationService

}
