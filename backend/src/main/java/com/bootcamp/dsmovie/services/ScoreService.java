package com.bootcamp.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.dsmovie.dto.MovieDTO;
import com.bootcamp.dsmovie.dto.ScoreDTO;
import com.bootcamp.dsmovie.entities.Movie;
import com.bootcamp.dsmovie.entities.Score;
import com.bootcamp.dsmovie.entities.User;
import com.bootcamp.dsmovie.repositories.MovieRepository;
import com.bootcamp.dsmovie.repositories.ScoreRepository;
import com.bootcamp.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sumScore = 0.0;
		for (Score s : movie.getScores()) {
			sumScore = sumScore + s.getValue();
		}
		
		double avgScore = sumScore / movie.getScores().size();
		
		movie.setScore(avgScore);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
	
}
