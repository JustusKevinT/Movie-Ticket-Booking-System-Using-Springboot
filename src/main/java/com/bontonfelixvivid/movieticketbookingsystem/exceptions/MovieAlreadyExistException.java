package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

public class MovieAlreadyExistException extends RuntimeException{
	
	private static final long serialVersionUID = 9045863543269746292L;
	
	public MovieAlreadyExistException() {
		super("Movie already exists with same name and language");
	}

}
