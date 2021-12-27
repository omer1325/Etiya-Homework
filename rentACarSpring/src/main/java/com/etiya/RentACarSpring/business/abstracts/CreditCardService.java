package com.etiya.RentACarSpring.business.abstracts;

import com.etiya.RentACarSpring.business.dtos.CreditCardDto;
import com.etiya.RentACarSpring.business.requests.creditCard.CreateCreditCardRequest;
import com.etiya.RentACarSpring.business.requests.creditCard.DeleteCreditCardRequest;
import com.etiya.RentACarSpring.business.requests.creditCard.UpdateCreditCardRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;

import java.util.List;
public interface CreditCardService {
	

	DataResult<List<CreditCardDto>> getAll();
	
	DataResult<List<CreditCardDto>> getCreditCardByCustomerId(int userId);
	

	Result add(CreateCreditCardRequest createCreditCardRequest);

	Result delete(DeleteCreditCardRequest deleteCreditCardRequest);
	
	Result update(UpdateCreditCardRequest updateCreditCardRequest);
	

	

	

	
}
