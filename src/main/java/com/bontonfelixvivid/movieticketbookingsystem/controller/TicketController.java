package com.bontonfelixvivid.movieticketbookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bontonfelixvivid.movieticketbookingsystem.requestdto.TicketRequestDTO;
import com.bontonfelixvivid.movieticketbookingsystem.responsedto.TicketResponseDTO;
import com.bontonfelixvivid.movieticketbookingsystem.service.TicketService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/bookTicket")
	public ResponseEntity<Object> ticketBooking(@RequestBody TicketRequestDTO ticketRequestDTO){
		try {
			TicketResponseDTO result = ticketService.ticketBooking(ticketRequestDTO);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
