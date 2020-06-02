package com.webBackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webBackEnd.dao.CartRepository;
import com.webBackEnd.entity.Cart;

@Service
public class CartService {
	@Autowired
    private CartRepository repository;
	
//	@Autowired
//	private CartInformationRepository cartInformationRepository;

    public Cart saveCart(Cart cart) {
        return repository.save(cart);
    }
    
    public List<Cart> saveCarts(List<Cart> carts) {
        return repository.saveAll(carts);
    }

    public List<Cart> getCarts() {
        return repository.findAll();
    }

    public Cart getCartById(int id) {
        return repository.findById(id).orElse(null);
    }
    
    //Need to add innerjoin query

//    public List<CartInformation> getCartinformationById() {
//        return cartInformationRepository.getCartInformation();
//    }    

    public String deleteCart(int id) {
        repository.deleteById(id);
        return "cart removed !! " + id;
    }
}
