package com.bontonfelixvivid.movieticketbookingsystem.requestdto;

import java.sql.Time;
import java.sql.Date;

import lombok.Data;

@Data
public class ShowRequestDTO {

	private Time showTime;
	private Date showDate;
	private Integer movieId;
	private Integer theaterId;
	public Integer getMovieId() {
		// TODO Auto-generated method stub
		return movieId;
	}
	public Integer getTheaterId() {
		// TODO Auto-generated method stub
		return theaterId;
	}
	
}
