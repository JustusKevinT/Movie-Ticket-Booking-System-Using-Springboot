package com.bontonfelixvivid.movieticketbookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bontonfelixvivid.movieticketbookingsystem.requestdto.TheaterRequestDTO;
import com.bontonfelixvivid.movieticketbookingsystem.requestdto.TheaterSeatRequestDTO;
import com.bontonfelixvivid.movieticketbookingsystem.service.TheaterService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/theater")
public class TheaterController {
	
	@Autowired
	private TheaterService theaterService;

	@PostMapping("/addNewTheater")
	public ResponseEntity<String> addTheater(@RequestBody TheaterRequestDTO theaterRequestDTO){
		try {
			String result = theaterService.addTheater(theaterRequestDTO);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addTheaterSeat")
	public ResponseEntity<String> addTheaterSeat(@RequestBody TheaterSeatRequestDTO theaterSeatRequestDTO){
		try {
			String result = theaterService.addTheaterSeat(theaterSeatRequestDTO);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
