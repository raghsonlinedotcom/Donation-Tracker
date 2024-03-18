package com.learning.mapper;

import org.springframework.stereotype.Component;

import com.learning.dto.DonationDto;
import com.learning.entity.Donation;

@Component
public class DonationMapper
{
	public static Donation mapToDonation(DonationDto donationDto)
	{
		Donation donation=new Donation(
				donationDto.getSl(),
				donationDto.getYear(),
				donationDto.getReceiptNumber(),
				donationDto.getAmount(),
				donationDto.getInstitution(),
				donationDto.getAddr(),
				donationDto.getPan(),
				donationDto.getDate(),
				donationDto.getTime());
		return donation;
				
	}
	
	public static DonationDto mapToDonationDto(Donation  donation)
	{
		DonationDto donationDto=new DonationDto(
				donation.getSl(),
				donation.getYear(),
				donation.getReceiptNumber(),
				donation.getAmount(),
				donation.getInstitution(),
				donation.getAddr(),
				donation.getPan(),
				donation.getDate(),
				donation.getTime());
		return donationDto;
				
	}
}
