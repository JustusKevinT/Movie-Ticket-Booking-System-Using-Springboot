package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

public class SeatsNotAvailableException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2935632296292489444L;

	public SeatsNotAvailableException() {
		super("Requested seats are not available");
	}
	
}
