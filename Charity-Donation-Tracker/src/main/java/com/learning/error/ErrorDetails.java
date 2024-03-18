package com.learning.error;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails 
{
	private String message;
	private String status;
	private LocalDateTime dateTime;

}
