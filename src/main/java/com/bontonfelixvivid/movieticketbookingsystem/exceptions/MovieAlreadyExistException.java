package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

import java.io.Serial;

public class MovieAlreadyExistException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 9045863543269746292L;
	
	public MovieAlreadyExistException() {
		super("Movie already exists with same name and language");
	}

}
