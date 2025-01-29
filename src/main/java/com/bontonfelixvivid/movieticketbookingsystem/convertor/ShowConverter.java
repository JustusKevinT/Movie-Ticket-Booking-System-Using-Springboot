package com.bontonfelixvivid.movieticketbookingsystem.convertor;

import com.bontonfelixvivid.movieticketbookingsystem.entity.Show;
import com.bontonfelixvivid.movieticketbookingsystem.requestdto.ShowRequestDTO;

public class ShowConverter {

	public static Show showDTOToShowObject(ShowRequestDTO showRequestDTO) {
		Show showObject = Show.builder().showTime(showRequestDTO.getShowTime()).showDate(showRequestDTO.getShowDate()).build();
		return showObject;
	}
	
}
