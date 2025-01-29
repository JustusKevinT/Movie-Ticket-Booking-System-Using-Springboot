package com.bontonfelixvivid.movieticketbookingsystem.requestdto;

import lombok.Data;

@Data
public class TheaterSeatRequestDTO {

	private String theaterAddress;
	private Integer numberOfSeatInRow;
	private Integer numberOfPremiumSeat;
	private Integer numberofExecutiveSeat;
	public String getTheaterAddress() {
		// TODO Auto-generated method stub
		return theaterAddress;
	}
	public Integer getNumberOfSeatInRow() {
		// TODO Auto-generated method stub
		return numberOfSeatInRow;
	}
	public Integer getNumberOfPremiumSeat() {
		// TODO Auto-generated method stub
		return numberOfPremiumSeat;
	}
	public Integer getNumberofExecutiveSeat() {
		// TODO Auto-generated method stub
		return numberofExecutiveSeat;
	}
}
