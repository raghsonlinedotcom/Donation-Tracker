package com.learning.exception;

public class DonationDetailsNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DonationDetailsNotFoundException()
	{
		
	}
	public DonationDetailsNotFoundException(String message)
	{
		super(message);
	}

}
