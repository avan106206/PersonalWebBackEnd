package com.webBackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webBackEnd.dao.ProductsRepository;
import com.webBackEnd.entity.Product;
import com.webBackEnd.entity.Products;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository repository;

    public List<Products> getProducts() {
        return repository.findAll();
    }

    public Products getProductById(int id) {
        return repository.findById(id).orElse(null);
    }
    
    public List<Products> getProductByCategoryId(int category_id) {
        return repository.findproductbycatid(category_id);
    }

    
/*
    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }*/


}
