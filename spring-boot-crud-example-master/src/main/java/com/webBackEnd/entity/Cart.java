package com.webBackEnd.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int cart_id;

	@Column(name = "auth_user_id")
	private int auth_user_id;

	@Column(name = "product_id")
	private int product_id;
	
	@Column(name = "neednum")
	private int neednum;
	
	//@Column(name = "auth_user_id")
	//private int auth_user_id;//user join column auth_user_id to bind user entity, for further join action
	
	public int getNeednum() {
		return neednum;
	}

	public void setNeednum(int neednum) {
		this.neednum = neednum;
	}
	
	public int getCart_id() {
		return cart_id;
	}
	

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getProduct_id() {
		return product_id;
	}


	
//	public int getAuth_user_id() {
//		return auth_user_id;
//	}
//
//	public void setAuth_user_id(int auth_user_id) {
//		this.auth_user_id = auth_user_id;
//	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getAuth_user_id() {
		return auth_user_id;
	}

	public void setAuth_user_id(int auth_user_id) {
		this.auth_user_id = auth_user_id;
	}




}
