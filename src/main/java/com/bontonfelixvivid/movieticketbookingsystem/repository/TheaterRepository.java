package com.bontonfelixvivid.movieticketbookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bontonfelixvivid.movieticketbookingsystem.entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Integer>{

	public Theater findByTheaterAddress(String theaterAddress);
	
}
