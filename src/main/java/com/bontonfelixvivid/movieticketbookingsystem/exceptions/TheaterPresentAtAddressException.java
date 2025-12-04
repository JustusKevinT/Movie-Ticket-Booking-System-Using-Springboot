package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

import java.io.Serial;

public class TheaterPresentAtAddressException extends RuntimeException{

    /**
     * 
     */
    @Serial
    private static final long serialVersionUID = 7375979271874743654L;

	public TheaterPresentAtAddressException() {
		super("Theater is present on this address");
	}
	
}
