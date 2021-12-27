package com.etiya.RentACarSpring.business.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.business.dtos.IndividualCustomerDto;
import com.etiya.RentACarSpring.business.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.RentACarSpring.business.requests.individualCustomer.DeleteIndividualCustomerRequest;
import com.etiya.RentACarSpring.business.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;

public interface IndividualCustomerService {
	
	
	Result add(CreateIndividualCustomerRequest createIndividualCustomerRequest);

	Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);

	Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest);

	DataResult<List<IndividualCustomerDto>> getAll();
}
