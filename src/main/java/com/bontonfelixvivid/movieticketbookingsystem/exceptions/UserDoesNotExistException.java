package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

import java.io.Serial;

public class UserDoesNotExistException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 6386810783666583417L;

	public UserDoesNotExistException() {
		super("User does not exist");
	}
}
