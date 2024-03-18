package com.learning.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dto.DonationDto;
import com.learning.entity.Donation;
import com.learning.exception.DonationDetailsNotFoundException;
import com.learning.mapper.DonationMapper;
import com.learning.repo.IDonationRepo;

@Service
public class DonationServiceImpl implements IDonationService
{
	@Autowired
	IDonationRepo repo;

	@Override
	public String saveDonationDetails(DonationDto donationDto) 
	{
		//To Set Current Date from LocalSystem
		String dateString=LocalDateTime.now().getDayOfMonth()+"-"
						 +LocalDateTime.now().getMonth()+"-"
						 +LocalDateTime.now().getYear();
		donationDto.setDate(dateString);
		
		//To Set Current Time From LocalSystem
		String time=LocalDateTime.now().getHour()+":"
				   +LocalDateTime.now().getMinute()+":"
				   +LocalDateTime.now().getSecond()+" CST";
        donationDto.setTime(time);
        
        Donation donation=DonationMapper.mapToDonation(donationDto);
        
		Donation result=repo.save(donation);
		return "Donation Details Added Successfully with SL# : "+result.getSl();
	}

	@Override
	public List<DonationDto> fetchAllDonations() {
		List<Donation> donationsList=repo.findAll();
		return donationsList.stream()
				.map((d)->DonationMapper.mapToDonationDto(d))
				.collect(Collectors.toList());
	}

	@Override
	public DonationDto getDonationInfoById(Long sl) {
		Donation donation=repo.findById(sl)
				.orElseThrow(()->new DonationDetailsNotFoundException("Donation Details Not Found With Given Number : "+sl));
		return DonationMapper.mapToDonationDto(donation);
	}

	@Override
	public String deleteDonationById(Long sl) {
		Donation donation=repo.findById(sl).orElse(null);
		if(donation!=null)
		{
			repo.deleteById(sl);
			return "Donation Details with SL : "+sl+" Deleted Successfully";
		}
		else
		{
			throw new DonationDetailsNotFoundException("Donation Details are not available with the given Specific SL : "+sl);
		}
	}

	@Override
	public String updateDonationById(Long sl, DonationDto donationDto) 
	{
		Donation donationFound=repo.findById(sl).orElse(null);
		
		if(donationFound!=null)
		{
			donationFound.setYear(donationDto.getYear());
			//To Set Current Date from System
			String dateString=LocalDateTime.now().getDayOfMonth()+"-"
							 +LocalDateTime.now().getMonth()+"-"
							 +LocalDateTime.now().getYear();
			
			//To Set Current Time From LocalSystem
			String time=LocalDateTime.now().getHour()+":"
					   +LocalDateTime.now().getMinute()+":"
					   +LocalDateTime.now().getSecond()+" CST";
	        donationFound.setTime(time);
			donationFound.setDate(dateString);
			donationFound.setAmount(donationDto.getAmount());
			donationFound.setInstitution(donationDto.getInstitution());
			donationFound.setAddr(donationDto.getAddr());
			donationFound.setPan(donationDto.getPan());
			
			repo.save(donationFound);
			
			return "Donation Details Updated Successfully";
		}
		else
		{
			throw new DonationDetailsNotFoundException("Donation Details Not Found with Given Sl : "+sl+" to Update");
		}
	}

}
