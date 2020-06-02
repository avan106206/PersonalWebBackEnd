package com.webBackEnd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webBackEnd.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {
    //Products findByName(String name);
	@Query("select p from Products p where p.category_id = :category_id")
	List<Products> findproductbycatid(
			@Param("category_id") int category_id
			);
    //Products findById(int id);
}

