package com.webBackEnd.dao;

import java.util.List;

import com.webBackEnd.entity.Cart;

public interface UserCartProjection {
	
	
	int getAuth_user_id();
	
	int getProduct_id();
	
	String getFirst_name();
	
	String getLast_name();
	
	int getCart_id();
	
	int getNeednum();
	
	String getProduct_name();
	
	String getPrice();
	
	//List<Cart> getcart();
	
}
