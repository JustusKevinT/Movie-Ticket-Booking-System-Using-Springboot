package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

import java.io.Serial;

public class SeatAlreadyAssociatedException extends RuntimeException{

    /**
     * 
     */
    @Serial
    private static final long serialVersionUID = 1236886455773586485L;

	public SeatAlreadyAssociatedException() {
		super("Seats already associated for this show id");
		// TODO Auto-generated constructor stub
	}

	
}
