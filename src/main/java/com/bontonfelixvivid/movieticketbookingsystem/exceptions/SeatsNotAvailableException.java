package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

import java.io.Serial;

public class SeatsNotAvailableException extends RuntimeException{

    /**
     * 
     */
    @Serial
    private static final long serialVersionUID = 2935632296292489444L;

	public SeatsNotAvailableException() {
		super("Requested seats are not available");
	}
	
}
