package com.bontonfelixvivid.movieticketbookingsystem.exceptions;

import java.io.Serial;

public class ShowAlreadyExistException extends RuntimeException{
    /**
     * 
     */
    @Serial
    private static final long serialVersionUID = -7046299047301321478L;
	
	public ShowAlreadyExistException() {
		super("Show already exists");
		// TODO Auto-generated constructor stub
	}

}
