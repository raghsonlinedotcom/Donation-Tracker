package com.learning.service;

import java.util.List;

import com.learning.dto.DonationDto;

public interface IDonationService 
{
	public String saveDonationDetails(DonationDto donationDto);
	public List<DonationDto> fetchAllDonations();
	public DonationDto getDonationInfoById(Long sl);
	public String deleteDonationById(Long sl);
	public String updateDonationById(Long sl,DonationDto donationDto);
}
