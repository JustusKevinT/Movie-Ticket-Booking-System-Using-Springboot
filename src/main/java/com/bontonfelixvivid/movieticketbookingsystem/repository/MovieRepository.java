package com.bontonfelixvivid.movieticketbookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bontonfelixvivid.movieticketbookingsystem.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	public Movie findMovieByMovieName(String movieName);

}
