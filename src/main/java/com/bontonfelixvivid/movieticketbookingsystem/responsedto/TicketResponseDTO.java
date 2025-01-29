package com.bontonfelixvivid.movieticketbookingsystem.responsedto;

import java.sql.Date;
import java.sql.Time;

import com.bontonfelixvivid.movieticketbookingsystem.enums.SeatType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponseDTO {
	
	private Time showTime;
	private Date showDate;
	private String movieName;
	private String theaterName;
	private SeatType seatType;
	private String bookedSeats;
	private Integer totalTicketsPrice;
	private String theaterAddress;

}
