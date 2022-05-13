package com.bootcamp.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
//CRUD operations
}
