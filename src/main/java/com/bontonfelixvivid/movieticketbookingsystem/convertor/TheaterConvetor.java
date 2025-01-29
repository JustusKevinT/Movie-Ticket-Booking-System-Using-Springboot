package com.bontonfelixvivid.movieticketbookingsystem.convertor;

import com.bontonfelixvivid.movieticketbookingsystem.entity.Theater;
import com.bontonfelixvivid.movieticketbookingsystem.requestdto.TheaterRequestDTO;

public class TheaterConvetor {

	public static Theater theaterDTOToTheaterObject(TheaterRequestDTO theaterRequestDTO) {
		Theater theaterObject = Theater.builder().theaterName(theaterRequestDTO.getTheaterName())
				.theaterAddress(theaterRequestDTO.getTheaterAddress()).build();
		return theaterObject;
	}

}
