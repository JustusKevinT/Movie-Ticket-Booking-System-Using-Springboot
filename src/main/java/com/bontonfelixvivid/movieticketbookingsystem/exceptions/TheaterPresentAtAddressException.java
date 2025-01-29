package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

public class TheaterPresentAtAddressException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7375979271874743654L;

	public TheaterPresentAtAddressException() {
		super("Theater is present on this address");
	}
	
}
