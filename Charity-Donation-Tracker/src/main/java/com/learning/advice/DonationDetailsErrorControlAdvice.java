package com.learning.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learning.error.ErrorDetails;
import com.learning.exception.DonationDetailsNotFoundException;

@RestControllerAdvice
public class DonationDetailsErrorControlAdvice 
{
	@ExceptionHandler(DonationDetailsNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleDonationDetailsNotFoundException(DonationDetailsNotFoundException dd)
	{
		ErrorDetails details=new ErrorDetails();
		details.setStatus("404-Not Found");
		details.setMessage(dd.getMessage());
		details.setDateTime(LocalDateTime.now());
		return new ResponseEntity<>(details,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllExceptions(Exception e)
	{
		ErrorDetails details=new ErrorDetails();
		details.setStatus("600-Internal Server Error");
		details.setMessage(e.getMessage());
		details.setDateTime(LocalDateTime.now());
		return new ResponseEntity<>(details,HttpStatus.CONFLICT);	
	}

}
