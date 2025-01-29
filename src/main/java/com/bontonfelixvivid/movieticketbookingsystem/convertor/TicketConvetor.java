package com.bontonfelixvivid.movieticketbookingsystem.convertor;

import com.bontonfelixvivid.movieticketbookingsystem.entity.Show;
import com.bontonfelixvivid.movieticketbookingsystem.entity.Ticket;
import com.bontonfelixvivid.movieticketbookingsystem.responsedto.TicketResponseDTO;

public class TicketConvetor {

	public static TicketResponseDTO TicketObjectToTicketDTO(Show showObject, Ticket ticketObject) {
		TicketResponseDTO ticketResponseDTOObject = TicketResponseDTO.builder().bookedSeats(ticketObject.getBookedSeats())
				.theaterAddress(showObject.getTheater().getTheaterAddress()).theaterName(showObject.getTheater().getTheaterName())
				.showDate(showObject.getShowDate()).showTime(showObject.getShowTime())
				.seatType(ticketObject.getSeatType()).movieName(showObject.getMovie().getMovieName())
				.totalTicketsPrice(ticketObject.getTotalTicketsPrice()).build();
		return ticketResponseDTOObject;
	}
}
