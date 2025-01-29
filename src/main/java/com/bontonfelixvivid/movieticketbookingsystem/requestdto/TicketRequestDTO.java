package com.bontonfelixvivid.movieticketbookingsystem.requestdto;

import java.util.List;

import com.bontonfelixvivid.movieticketbookingsystem.enums.SeatType;

import lombok.Data;

@Data
public class TicketRequestDTO {

	private Integer userId;
	private Integer showId;
	private SeatType seatType;
	private List<String> requestSeats;
	public Integer getShowId() {
		// TODO Auto-generated method stub
		return showId;
	}
	public List<String> getRequestSeats() {
		// TODO Auto-generated method stub
		return requestSeats;
	}
	public Integer getUserId() {
		// TODO Auto-generated method stub
		return userId;
	}
	
}
