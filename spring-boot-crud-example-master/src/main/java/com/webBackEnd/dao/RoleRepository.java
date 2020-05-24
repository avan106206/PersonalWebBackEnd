package com.webBackEnd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webBackEnd.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	public Role findByRole(String role);//import the String of role return the Role object

}
