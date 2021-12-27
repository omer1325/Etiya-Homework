package com.etiya.RentACarSpring.business.abstracts;

import com.etiya.RentACarSpring.business.dtos.RentalDto;
import com.etiya.RentACarSpring.business.requests.rental.CreateRentalRequest;
import com.etiya.RentACarSpring.business.requests.rental.UpdateRentalRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;

import java.util.List;

public interface RentalService {
	
   
    DataResult<List<RentalDto>> getAll();
	
	DataResult<RentalDto> getById(int rentalId);
	
	Result addCorporateCustomer(CreateRentalRequest createRentalRequest);
	Result addIndividualCustomer(CreateRentalRequest createRentalRequest);
	
	Result updateCorporateCustomer(UpdateRentalRequest updateRentalRequest);
	Result updateIndividualCustomer(UpdateRentalRequest updateRentalRequest);
	
	


	
	
	
	
	

	


}
