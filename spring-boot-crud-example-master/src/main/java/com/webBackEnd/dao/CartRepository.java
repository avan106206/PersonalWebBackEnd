package com.webBackEnd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webBackEnd.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    
	//@Query(value="")
	//List
	
}

