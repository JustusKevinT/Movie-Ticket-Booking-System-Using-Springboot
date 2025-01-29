package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

public class UserAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5157215069925581561L;

	public UserAlreadyExistException() {
		super("User already exists");
	}
	
}
