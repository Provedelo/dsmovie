package com.bootcamp.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
//CRUD operations
	User findByEmail(String email);
}