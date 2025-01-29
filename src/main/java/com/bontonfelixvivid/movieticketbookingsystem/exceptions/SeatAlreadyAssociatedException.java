package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

public class SeatAlreadyAssociatedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1236886455773586485L;

	public SeatAlreadyAssociatedException() {
		super("Seats already associated for this show id");
		// TODO Auto-generated constructor stub
	}

	
}
