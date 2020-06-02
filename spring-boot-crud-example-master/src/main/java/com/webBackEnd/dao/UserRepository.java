package com.webBackEnd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webBackEnd.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(nativeQuery = true, value = "select u.auth_user_id as auth_user_id, u.first_name as first_name, u.last_name as last_name, c.cart_id as cart_id, c.neednum as neednum, c.product_id as product_id,  p.name as product_name, p.price as price from auth_user u inner join cart c on u.auth_user_id = 8 inner join products p on c.product_id = p.id")
	List<UserCartProjection> findcart();

	User findByemail(String email);	
	    

}
