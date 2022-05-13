package com.bootcamp.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_score")
public class Score {
	
	@EmbeddedId                         //id to be embedded in another table embedable = incorporável
	private ScorePK id = new ScorePK(); //Compost Key for User and Movie ID
	private Double value;
	
	public Score() {
	}

	public Score(ScorePK id, Double value) {
		super();
		this.id = id;
		this.value = value;
	}

	public void setMovie(Movie movie) { //Gets movie from ScorePK, set reference from id!
		id.setMovie(movie);
	}
	
	public void setUser(User user) { 
		id.setUser(user);
	}
	
	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
}
