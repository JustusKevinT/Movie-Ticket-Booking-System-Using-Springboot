package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

public class TheaterDoesNotExistException extends RuntimeException{
	
	private static final long serialVersionUID = 2885350098352987762L;

	public TheaterDoesNotExistException() {
		super("Theater does not Exist");
	}
	
}
