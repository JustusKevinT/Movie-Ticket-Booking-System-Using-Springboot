package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

public class MovieDoesNotExistException extends RuntimeException{
	
	private static final long serialVersionUID = 5385129013790060240L;

	public MovieDoesNotExistException() {
		super("Movie dose not Exist");
	}

}
