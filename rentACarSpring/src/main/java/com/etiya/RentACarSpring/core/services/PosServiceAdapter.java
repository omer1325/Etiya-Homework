package com.etiya.RentACarSpring.core.services;


import com.etiya.RentACarSpring.business.abstracts.CreditCardValidatorService;
import com.etiya.RentACarSpring.business.requests.get.CreatePosRequest;
import org.springframework.stereotype.Service;

@Service
public class PosServiceAdapter implements CreditCardValidatorService {
	
	PosService posService = new PosService();

	@Override
	public boolean isValid(CreatePosRequest createPosRequest) {
		
		return posService.posServiceVerification(createPosRequest.getCvc(), 
				createPosRequest.getCardNumber(),
				createPosRequest.getPullDate(),
				createPosRequest.getPrice());
	}

    

}

