package com.etiya.RentACarSpring.business.abstracts;


import com.etiya.RentACarSpring.business.requests.get.CreatePosRequest;

public interface CreditCardValidatorService {
	
	boolean isValid(CreatePosRequest createPosRequest);
	
	
}
