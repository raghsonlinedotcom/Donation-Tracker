package com.learning.entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.DonationDto;
import com.learning.service.IDonationService;

@RestController
@RequestMapping("/api")
public class DonationDetailsController 
{
	@Autowired
	private IDonationService service;
	
	//Adding New Donation Details
	@PostMapping("/add")
	public ResponseEntity<String> addNewDonationDetails(@RequestBody DonationDto donationDto)
	{
		String msg=service.saveDonationDetails(donationDto);
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	
	//Displaying All the Donation Details
	@GetMapping("/getAll")
	public ResponseEntity<List<DonationDto>> displayAllDonations()
	{
		List<DonationDto> list=service.fetchAllDonations();
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
	
	//Retrieving Donation Details By SL
	@GetMapping("/get/{sl}")
	public ResponseEntity<DonationDto> fetchDonationBySl(@PathVariable("sl")Long sl)
	{
		DonationDto donationDto=service.getDonationInfoById(sl);
		return new ResponseEntity<DonationDto>(donationDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{sl}")
	public ResponseEntity<String> deleteCourseById(@PathVariable("sl")Long sl)
	{
		String msg=service.deleteDonationById(sl);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/update/{sl}")
	public ResponseEntity<String> updateCourseById(@PathVariable("sl")Long sl,@RequestBody DonationDto donationDto)
	{
		String msg=service.updateDonationById(sl, donationDto);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
	
}
