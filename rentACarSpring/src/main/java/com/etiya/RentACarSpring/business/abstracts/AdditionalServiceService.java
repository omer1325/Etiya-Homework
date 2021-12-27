package com.etiya.RentACarSpring.business.abstracts;
import java.util.List;

import com.etiya.RentACarSpring.business.dtos.AdditionalServiceDetailDto;
import com.etiya.RentACarSpring.business.requests.additionalService.CreateAdditionalServiceRequest;
import com.etiya.RentACarSpring.business.requests.additionalService.DeleteAdditionalServiceRequest;
import com.etiya.RentACarSpring.business.requests.additionalService.UpdateAdditionalServiceRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;


public interface AdditionalServiceService {
	
	DataResult<AdditionalServiceDetailDto> getById(int additionalId);
	
	DataResult<List<AdditionalServiceDetailDto>> getAll();
    
	Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest);
	
	Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest);
	
	Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequest);
	
	DataResult<List<AdditionalServiceDetailDto>> getByRentalId(int rentalId);

}
