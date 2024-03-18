package com.learning.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="80G Donations-FY2021-22(AY 2022-23)")
public class Donation 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SL#")
	private Long sl;
	
	@Column(name="FY")
	private String year;
	
	@Column(name="Receipt#")
	private String receiptNumber;
	
	@Column(name="Amount")
	private Long amount;
	
	@Column(name="Institution")
	private String institution;
	
	@Column(name="Address")
	private String addr;
	
	@Column(name="PAN")
	private String pan;

	@Column(name="Date")
	private String date;
	
	@Column(name="Time")
	private String time;
}
