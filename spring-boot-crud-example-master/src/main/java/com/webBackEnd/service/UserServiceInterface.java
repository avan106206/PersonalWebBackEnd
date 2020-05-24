package com.webBackEnd.service;

import org.springframework.stereotype.Service;

import com.webBackEnd.entity.User;

@Service
public interface UserServiceInterface { //outline for the class which implement this interface, the below abstract must existed in the target class
	
	public void saveUser(User user);
	public boolean isUserAlreadyPresent(User user);
	
}
