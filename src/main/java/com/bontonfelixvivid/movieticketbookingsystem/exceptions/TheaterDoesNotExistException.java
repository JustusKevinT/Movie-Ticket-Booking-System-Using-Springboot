package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

import java.io.Serial;

public class TheaterDoesNotExistException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 2885350098352987762L;

	public TheaterDoesNotExistException() {
		super("Theater does not Exist");
	}
	
}
