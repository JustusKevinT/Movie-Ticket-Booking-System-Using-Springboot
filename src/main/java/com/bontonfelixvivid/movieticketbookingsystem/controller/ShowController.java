package com.bontonfelixvivid.movieticketbookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bontonfelixvivid.movieticketbookingsystem.requestdto.ShowRequestDTO;
import com.bontonfelixvivid.movieticketbookingsystem.requestdto.ShowSeatRequestDTO;
import com.bontonfelixvivid.movieticketbookingsystem.service.ShowService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/show")
public class ShowController {
	
	@Autowired
	private ShowService showService;
	
	@PostMapping("/addNewShow")
	public ResponseEntity<String> addShow(@RequestBody ShowRequestDTO showRequestDTO){
		try {
			String result = showService.addShow(showRequestDTO);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/associateSeats")
	public ResponseEntity<String> associateShowSeats(@RequestBody ShowSeatRequestDTO showSeatRequestDTO){
		try {
			String result = showService.associateShowSeats(showSeatRequestDTO);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PatchMapping("/updateSeats")
	public ResponseEntity<String> updateShowSeats(@RequestBody ShowSeatRequestDTO showSeatRequestDTO){
		try {
			String result = showService.updateShowSeat(showSeatRequestDTO);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
