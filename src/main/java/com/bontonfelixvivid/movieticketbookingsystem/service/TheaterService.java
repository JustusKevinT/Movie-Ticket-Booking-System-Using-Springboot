package com.bontonfelixvivid.movieticketbookingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bontonfelixvivid.movieticketbookingsystem.convertor.TheaterConvetor;
import com.bontonfelixvivid.movieticketbookingsystem.entity.Theater;
import com.bontonfelixvivid.movieticketbookingsystem.entity.TheaterSeat;
import com.bontonfelixvivid.movieticketbookingsystem.enums.SeatType;
import com.bontonfelixvivid.movieticketbookingsystem.exceptions.TheaterNotPresentAtAddressException;
import com.bontonfelixvivid.movieticketbookingsystem.exceptions.TheaterPresentAtAddressException;
import com.bontonfelixvivid.movieticketbookingsystem.repository.TheaterRepository;
import com.bontonfelixvivid.movieticketbookingsystem.requestdto.TheaterRequestDTO;
import com.bontonfelixvivid.movieticketbookingsystem.requestdto.TheaterSeatRequestDTO;

@Service
public class TheaterService {
	
	@Autowired
	private TheaterRepository theaterRepository;

	public String addTheater(TheaterRequestDTO theaterRequestDTO) throws TheaterPresentAtAddressException {
		// TODO Auto-generated method stub
		if(theaterRepository.findByTheaterAddress(theaterRequestDTO.getTheaterAddress()) != null) {
			throw new TheaterPresentAtAddressException();
		}
		Theater theaterObject = TheaterConvetor.theaterDTOToTheaterObject(theaterRequestDTO);
		theaterRepository.save(theaterObject);
		return "Theater saved successfully";
	}
	
	public String addTheaterSeat(TheaterSeatRequestDTO theaterSeatRequestDTO) throws TheaterNotPresentAtAddressException {
	    if(theaterRepository.findByTheaterAddress(theaterSeatRequestDTO.getTheaterAddress()) == null) {
	        throw new TheaterNotPresentAtAddressException();
	    }

	    Integer numberOfSeatsInRow = theaterSeatRequestDTO.getNumberOfSeatInRow();
	    Integer numberOfPremiumSeat = theaterSeatRequestDTO.getNumberOfPremiumSeat();
	    Integer numberOfExecutiveSeat = theaterSeatRequestDTO.getNumberofExecutiveSeat();
	    String theaterAddress = theaterSeatRequestDTO.getTheaterAddress();
	    Theater theaterObject = theaterRepository.findByTheaterAddress(theaterAddress);
	    List<TheaterSeat> theaterSeatListObject = theaterObject.getTheaterSeatList();

	    // Initialize counters for seat numbering
	    int counter = 1, fill = 0;
	    char ch = 'A';

	    // Add executive seats
	    for(int i = 1; i <= numberOfExecutiveSeat; i++) {
	        String seatNumber = Integer.toString(counter) + ch;
	        ch++;
	        fill++;
	        
	        // If character exceeds 'Z', reset to 'A' and increment the counter
	        if(ch > 'Z') {
	        	ch = 'A';
	        	counter++;
	        }
	        
	        if(fill == numberOfSeatsInRow) {
	            fill = 0;
	            counter++;
	            ch = 'A';  // Reset to 'A' after reaching end of row
	        }
	        TheaterSeat theaterSeatObject = new TheaterSeat();
	        theaterSeatObject.setSeatNumber(seatNumber);
	        theaterSeatObject.setSeatType(SeatType.EXECUTIVE);
	        theaterSeatObject.setTheater(theaterObject);
	        theaterSeatListObject.add(theaterSeatObject);
	    }

	    // Reset counter and character for premium seats
	    counter = 1;
	    ch = 'A';
	    fill = 0;

	    // Add premium seats
	    for(int i = 1; i <= numberOfPremiumSeat; i++) {
	        String seatNumber = Integer.toString(counter) + ch;
	        ch++;
	        fill++;
	        
	        // If character exceeds 'Z', reset to 'A' and increment the counter
	        if(ch > 'Z') {
	        	ch = 'A';
	        	counter++;
	        }
	        
	        if(fill == numberOfSeatsInRow) {
	            fill = 0;
	            counter++;
	            ch = 'A';  // Reset to 'A' after reaching end of row
	        }
	        TheaterSeat theaterSeatObject = new TheaterSeat();
	        theaterSeatObject.setSeatNumber(seatNumber);
	        theaterSeatObject.setSeatType(SeatType.PREMIUM);
	        theaterSeatObject.setTheater(theaterObject);
	        theaterSeatListObject.add(theaterSeatObject);
	    }

	    // Save the updated theater object
	    theaterRepository.save(theaterObject);
	    return "Theater seats added successfully";
	}

}
