package com.etiya.RentACarSpring.business.abstracts;

import com.etiya.RentACarSpring.business.dtos.CarDamageDto;
import com.etiya.RentACarSpring.business.requests.carDamage.CreateCarDamageRequest;
import com.etiya.RentACarSpring.business.requests.carDamage.DeleteCarDamagesRequest;
import com.etiya.RentACarSpring.business.requests.carDamage.UpdateCarDamageRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;

import java.util.List;

public interface CarDamageService {
	
	DataResult<List<CarDamageDto>> getAll();
	
	DataResult<CarDamageDto> getById(int carDamagesId);
	
	Result add(CreateCarDamageRequest createCarDamageRequest );
	
	Result update(UpdateCarDamageRequest updateCarDamageRequest);
	
	Result delete(DeleteCarDamagesRequest deleteCarDamagesRequest);
	
	

}
