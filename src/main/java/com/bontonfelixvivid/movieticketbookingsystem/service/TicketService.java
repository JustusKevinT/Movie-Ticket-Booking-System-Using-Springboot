package com.bontonfelixvivid.movieticketbookingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bontonfelixvivid.movieticketbookingsystem.convertor.TicketConvetor;
import com.bontonfelixvivid.movieticketbookingsystem.entity.Show;
import com.bontonfelixvivid.movieticketbookingsystem.entity.ShowSeat;
import com.bontonfelixvivid.movieticketbookingsystem.entity.Ticket;
import com.bontonfelixvivid.movieticketbookingsystem.entity.User;
import com.bontonfelixvivid.movieticketbookingsystem.enums.SeatType;
import com.bontonfelixvivid.movieticketbookingsystem.exceptions.SeatsNotAvailableException;
import com.bontonfelixvivid.movieticketbookingsystem.exceptions.ShowDoesNotExistException;
import com.bontonfelixvivid.movieticketbookingsystem.exceptions.UserDoesNotExistException;
import com.bontonfelixvivid.movieticketbookingsystem.repository.ShowRepository;
import com.bontonfelixvivid.movieticketbookingsystem.repository.TicketRepository;
import com.bontonfelixvivid.movieticketbookingsystem.repository.UserRepository;
import com.bontonfelixvivid.movieticketbookingsystem.requestdto.TicketRequestDTO;
import com.bontonfelixvivid.movieticketbookingsystem.responsedto.TicketResponseDTO;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private ShowRepository showRepository;

	@Autowired
	private UserRepository userRepository;

	public TicketResponseDTO ticketBooking(TicketRequestDTO ticketRequestDTO)
			throws SeatsNotAvailableException, UserDoesNotExistException, ShowDoesNotExistException {
		// TODO Auto-generated method stub
		Optional<Show> showOptionalObject = showRepository.findById(ticketRequestDTO.getShowId());

		if (showOptionalObject.isEmpty()) {
			throw new ShowDoesNotExistException();
		}

		Optional<User> userOptionalObject = userRepository.findById(ticketRequestDTO.getUserId());

		if (userOptionalObject.isEmpty()) {
			throw new UserDoesNotExistException();
		}

		User userObject = userOptionalObject.get();
		Show showObject = showOptionalObject.get();

		Boolean isSeatAvailable = isSeatAvailable(showObject.getShowSeatList(), ticketRequestDTO.getRequestSeats(),
				ticketRequestDTO.getSeatType());

		if (!isSeatAvailable) {
			throw new SeatsNotAvailableException();
		}

		Integer getPriceAndAssignSeats = getPriceAndAssignSeats(showObject.getShowSeatList(),
				ticketRequestDTO.getRequestSeats(), ticketRequestDTO.getSeatType());

		String seats = listToString(ticketRequestDTO.getRequestSeats());

		Ticket ticketObject = new Ticket();
		ticketObject.setTotalTicketsPrice(getPriceAndAssignSeats);
		ticketObject.setSeatType(ticketRequestDTO.getSeatType());
		ticketObject.setBookedSeats(seats);
		ticketObject.setUser(userObject);
		ticketObject.setShow(showObject);

		ticketObject = ticketRepository.save(ticketObject);

		userObject.getTicketList().add(ticketObject);
		showObject.getTicketList().add(ticketObject);

		userRepository.save(userObject);
		showRepository.save(showObject);

		return TicketConvetor.TicketObjectToTicketDTO(showObject, ticketObject);

	}

	private String listToString(List<String> requestSeats) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < requestSeats.size(); i++) {
			sb.append(requestSeats.get(i));
			if (i < requestSeats.size() - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

	private Integer getPriceAndAssignSeats(List<ShowSeat> showSeatList, List<String> requestSeats, SeatType seatType) {
		// TODO Auto-generated method stub
		Integer totalAmount = 0;
		for (ShowSeat showSeatObject : showSeatList) {
			if (requestSeats.contains(showSeatObject.getSeatNumber()) && (seatType.equals(showSeatObject.getSeatType()))) {
				totalAmount += showSeatObject.getSeatPrice();
				showSeatObject.setIsAvailable(Boolean.FALSE);
			}
		}
		return totalAmount;
	}

	private Boolean isSeatAvailable(List<ShowSeat> showSeatList, List<String> requestSeats, SeatType seatType) {
		// TODO Auto-generated method stub
		for (ShowSeat showSeatObject : showSeatList) {
			String seatNumber = showSeatObject.getSeatNumber();
			if (requestSeats.contains(seatNumber) && (!showSeatObject.getIsAvailable())
					&& (seatType.equals(showSeatObject.getSeatType()))) {
				return false;
			}
		}
		return true;
	}

}
