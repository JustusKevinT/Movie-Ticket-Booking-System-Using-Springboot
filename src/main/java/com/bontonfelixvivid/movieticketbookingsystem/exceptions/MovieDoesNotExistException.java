package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

import java.io.Serial;

public class MovieDoesNotExistException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 5385129013790060240L;

	public MovieDoesNotExistException() {
		super("Movie dose not Exist");
	}

}
