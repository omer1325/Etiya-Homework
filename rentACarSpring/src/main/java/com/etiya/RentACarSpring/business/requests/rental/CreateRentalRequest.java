package com.etiya.RentACarSpring.business.requests.rental;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.etiya.RentACarSpring.business.dtos.AdditionalServiceDto;
import com.etiya.RentACarSpring.business.dtos.CreditCardDto;
import com.etiya.RentACarSpring.business.requests.get.CreatePosRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateRentalRequest  {
	
	
	@JsonIgnore
	private String pickUpCity;
	
	private String deliveryCity;
	
    private Date rentDate;
   
    private Date returnDate;

    
    @JsonIgnore
    private double amount;
   
    private int carId;
    private int customerId;
    
    private boolean saveCreditCard;
	private CreditCardDto creditCardDto;
  
    private List<AdditionalServiceDto> additionalServiceDtos;
    
    @Valid
    @JsonIgnore
    private CreatePosRequest createPosRequest;
    
    
    
  
	

}
