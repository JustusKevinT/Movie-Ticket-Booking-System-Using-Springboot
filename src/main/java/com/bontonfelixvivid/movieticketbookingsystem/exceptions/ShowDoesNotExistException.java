package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

import java.io.Serial;

public class ShowDoesNotExistException extends RuntimeException{

    /**
     * 
     */
    @Serial
    private static final long serialVersionUID = 7810096307365475292L;

	public ShowDoesNotExistException() {
		super("Show does not exist");
	}
	
}
