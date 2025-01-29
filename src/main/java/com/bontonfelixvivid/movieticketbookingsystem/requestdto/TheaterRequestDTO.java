package com.bontonfelixvivid.movieticketbookingsystem.requestdto;

import lombok.Data;

@Data
public class TheaterRequestDTO {

	private String theaterName;
	private String theaterAddress;
	public String getTheaterAddress() {
		// TODO Auto-generated method stub
		return theaterAddress;
	}
}
