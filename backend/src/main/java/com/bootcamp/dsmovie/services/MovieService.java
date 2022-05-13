package com.bootcamp.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.dsmovie.dto.MovieDTO;
import com.bootcamp.dsmovie.entities.Movie;
import com.bootcamp.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pegeable) {
		Page<Movie> result = repository.findAll(pegeable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;
	}
}
