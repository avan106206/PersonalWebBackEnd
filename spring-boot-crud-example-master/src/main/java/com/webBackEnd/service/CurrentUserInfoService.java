package com.webBackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webBackEnd.dao.UserCartProjection;
import com.webBackEnd.dao.UserRepository;
import com.webBackEnd.entity.User;

@Service
public class CurrentUserInfoService {

	@Autowired
	UserRepository userRepository;
	
	public User findByemail(String email) {
		return userRepository.findByemail(email);
	}
	
	public List<UserCartProjection> getCurrentCart(int auth_user_id){
		System.out.print(auth_user_id+"service");
		return userRepository.findcart(auth_user_id);
	}

}
