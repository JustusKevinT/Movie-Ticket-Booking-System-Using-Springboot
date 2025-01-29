package com.bontonfelixvivid.movieticketbookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bontonfelixvivid.movieticketbookingsystem.requestdto.MovieRequestDTO;
import com.bontonfelixvivid.movieticketbookingsystem.service.MovieService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@PostMapping("/addNewMovie")
	public ResponseEntity<String> addMovie(@RequestBody MovieRequestDTO movieRequestDTO){
		try {
			String result = movieService.addMovie(movieRequestDTO);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
