package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

public class ShowDoesNotExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7810096307365475292L;

	public ShowDoesNotExistException() {
		super("Show does not exist");
	}
	
}
