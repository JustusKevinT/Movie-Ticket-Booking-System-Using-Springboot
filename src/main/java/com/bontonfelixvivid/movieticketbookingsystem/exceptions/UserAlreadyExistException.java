package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

import java.io.Serial;

public class UserAlreadyExistException extends RuntimeException{

    /**
     * 
     */
    @Serial
    private static final long serialVersionUID = 5157215069925581561L;

	public UserAlreadyExistException() {
		super("User already exists");
	}
	
}
