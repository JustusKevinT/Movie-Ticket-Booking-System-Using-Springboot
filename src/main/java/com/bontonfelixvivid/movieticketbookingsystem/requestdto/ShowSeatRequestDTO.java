package com.bontonfelixvivid.movieticketbookingsystem.requestdto;

import lombok.Data;

@Data
public class ShowSeatRequestDTO {

	private Integer showId;
	private Integer premiumSeatPrice;
	private Integer executiveSeatPrice;
	public Integer getShowId() {
		// TODO Auto-generated method stub
		return showId;
	}
	public Integer getExecutiveSeatPrice() {
		// TODO Auto-generated method stub
		return executiveSeatPrice;
	}
	public Integer getPremiumSeatPrice() {
		// TODO Auto-generated method stub
		return premiumSeatPrice;
	}
	
}
