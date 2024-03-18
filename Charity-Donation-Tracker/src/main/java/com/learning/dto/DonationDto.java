package com.learning.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationDto 
{
	private Long sl;
	private String year;
	private String receiptNumber;
	private Long amount;
	private String institution;
	private String addr;
	private String pan;
	private String date;
	private String time;
}
