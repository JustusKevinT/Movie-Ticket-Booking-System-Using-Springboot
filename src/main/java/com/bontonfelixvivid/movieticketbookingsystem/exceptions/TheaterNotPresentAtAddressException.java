package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

public class TheaterNotPresentAtAddressException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2363332241855966074L;

	public TheaterNotPresentAtAddressException() {
		super("Theater is not present on this address");
	}
	
}
