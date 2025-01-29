package com.bontonfelixvivid.movieticketbookingsystem.requestdto;

import java.sql.Date;

import lombok.Data;

@Data
public class ShowTimingsRequestDTO {

	private Date showDate;
	private Integer theaterId;
	private Integer movieId;
	
}
