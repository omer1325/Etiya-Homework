package com.etiya.RentACarSpring.business.abstracts;

import com.etiya.RentACarSpring.business.dtos.CorporateCustomerDto;
import com.etiya.RentACarSpring.business.requests.corporateCustomer.CreateCorporateCustomerRequest;
import com.etiya.RentACarSpring.business.requests.corporateCustomer.DeleteCorporateCustomerRequest;
import com.etiya.RentACarSpring.business.requests.corporateCustomer.UpdateCorporateCustomerRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;

import java.util.List;

public interface CorporateCustomerService {

	Result add(CreateCorporateCustomerRequest createCorporateCustomerRequest);

	Result update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest);

	Result delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest);

	DataResult<List<CorporateCustomerDto>> getAll();
}
