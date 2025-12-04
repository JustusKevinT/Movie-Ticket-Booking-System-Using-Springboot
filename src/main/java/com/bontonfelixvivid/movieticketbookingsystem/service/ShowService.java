package com.bontonfelixvivid.movieticketbookingsystem.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bontonfelixvivid.movieticketbookingsystem.convertor.ShowConverter;
import com.bontonfelixvivid.movieticketbookingsystem.entity.Movie;
import com.bontonfelixvivid.movieticketbookingsystem.entity.Show;
import com.bontonfelixvivid.movieticketbookingsystem.entity.ShowSeat;
import com.bontonfelixvivid.movieticketbookingsystem.entity.Theater;
import com.bontonfelixvivid.movieticketbookingsystem.entity.TheaterSeat;
import com.bontonfelixvivid.movieticketbookingsystem.enums.SeatType;
import com.bontonfelixvivid.movieticketbookingsystem.exceptions.MovieDoesNotExistException;
import com.bontonfelixvivid.movieticketbookingsystem.exceptions.SeatAlreadyAssociatedException;
import com.bontonfelixvivid.movieticketbookingsystem.exceptions.ShowAlreadyExistException;
import com.bontonfelixvivid.movieticketbookingsystem.exceptions.ShowDoesNotExistException;
import com.bontonfelixvivid.movieticketbookingsystem.exceptions.TheaterDoesNotExistException;
import com.bontonfelixvivid.movieticketbookingsystem.repository.MovieRepository;
import com.bontonfelixvivid.movieticketbookingsystem.repository.ShowRepository;
import com.bontonfelixvivid.movieticketbookingsystem.repository.ShowSeatRepository;
import com.bontonfelixvivid.movieticketbookingsystem.repository.TheaterRepository;
import com.bontonfelixvivid.movieticketbookingsystem.requestdto.ShowRequestDTO;
import com.bontonfelixvivid.movieticketbookingsystem.requestdto.ShowSeatRequestDTO;

@Service
public class ShowService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private ShowRepository showRepository;

	@Autowired
	private ShowSeatRepository showSeatRepository;

	public String addShow(ShowRequestDTO showRequestDTO) {
		Show showDTOConvertedObject = ShowConverter.showDTOToShowObject(showRequestDTO);
		Optional<Movie> movieOptionalObject = movieRepository.findById(showRequestDTO.getMovieId());
		Optional<Theater> theaterOptionalObject = theaterRepository.findById(showRequestDTO.getTheaterId());
		if (movieOptionalObject.isEmpty()) {
			throw new MovieDoesNotExistException();
		}
		if (theaterOptionalObject.isEmpty()) {
			throw new TheaterDoesNotExistException();
		}
		Theater theaterObject = theaterOptionalObject.get();
		Movie movieObject = movieOptionalObject.get();

		// Check if a show with the same time, date, movie, and theater already exists
		Optional<Show> showObject = showRepository.findByShowTimeAndShowDateAndMovieAndTheater(
				showRequestDTO.getShowTime(), showRequestDTO.getShowDate(), movieObject, theaterObject);

		if (showObject.isPresent()) {
			throw new ShowAlreadyExistException();
		}

		// Set movie and theater objects to the show
		showDTOConvertedObject.setMovie(movieObject);
		showDTOConvertedObject.setTheater(theaterObject);

		showDTOConvertedObject = showRepository.save(showDTOConvertedObject);

		movieObject.getShows().add(showDTOConvertedObject);
		theaterObject.getShowList().add(showDTOConvertedObject);

		movieRepository.save(movieObject);
		theaterRepository.save(theaterObject);

		return "Show added successfully";

	}

	public String associateShowSeats(ShowSeatRequestDTO showSeatRequestDTO) {

		Optional<Show> showOptionalObject = showRepository.findById(showSeatRequestDTO.getShowId());
		if (showOptionalObject.isEmpty()) {
			throw new ShowDoesNotExistException();
		}

		Boolean isShowSeatExist = showSeatRepository.getIsShowSeatExist(showSeatRequestDTO.getShowId()) > 0 ? Boolean.TRUE
				: Boolean.FALSE;
		if (isShowSeatExist) {
			throw new SeatAlreadyAssociatedException();
		}

		Show showObject = showOptionalObject.get();
		Theater theaterObject = showObject.getTheater();
		List<TheaterSeat> theaterSeatList = theaterObject.getTheaterSeatList();
		List<ShowSeat> showSeatList = showObject.getShowSeatList();
		for (TheaterSeat theaterSeatObject : theaterSeatList) {
			ShowSeat showSeatObject = new ShowSeat();
			showSeatObject.setSeatNumber(theaterSeatObject.getSeatNumber());
			showSeatObject.setSeatType(theaterSeatObject.getSeatType());
			if (showSeatObject.getSeatType().equals(SeatType.EXECUTIVE)) {
				showSeatObject.setSeatPrice(showSeatRequestDTO.getExecutiveSeatPrice());
			} else {
				showSeatObject.setSeatPrice(showSeatRequestDTO.getPremiumSeatPrice());
			}
			showSeatObject.setShow(showObject);
			showSeatObject.setIsAvailable(Boolean.TRUE);
			showSeatObject.setIsFoodContains(Boolean.FALSE);
			showSeatList.add(showSeatObject);
		}
		showRepository.save(showObject);
		return "Show seats are associated successfully";
	}

	public String updateShowSeat(ShowSeatRequestDTO showSeatRequestDTO) {
		Optional<Show> showOptionalObject = showRepository.findById(showSeatRequestDTO.getShowId());
		if (showOptionalObject.isEmpty()) {
			throw new ShowDoesNotExistException();
		}

		Show showObject = showOptionalObject.get();
		List<ShowSeat> showSeatList = showObject.getShowSeatList();

		for (ShowSeat showSeatObject : showSeatList) {
			if (showSeatObject.getSeatType().equals(SeatType.EXECUTIVE)) {
				showSeatObject.setSeatPrice(showSeatRequestDTO.getExecutiveSeatPrice());
			} else if (showSeatObject.getSeatType().equals(SeatType.PREMIUM)) {
				showSeatObject.setSeatPrice(showSeatRequestDTO.getPremiumSeatPrice());
			}
		}
		showSeatRepository.saveAll(showSeatList);
		return "Show seats are updated successfully";
	}

}
