package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

public class UserDoesNotExistException extends RuntimeException{

	private static final long serialVersionUID = 6386810783666583417L;

	public UserDoesNotExistException() {
		super("User does not exist");
	}
}
