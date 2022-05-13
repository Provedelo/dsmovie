package com.bootcamp.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.dsmovie.entities.Score;
import com.bootcamp.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{
//CRUD operations
}
