package com.etiya.rentACarSpring.business.abstracts;

import java.util.List;

import com.etiya.rentACarSpring.business.dtos.CarSearchListDto;
import com.etiya.rentACarSpring.business.request.CreateCarRequest;
import com.etiya.rentACarSpring.business.request.DeleteCarRequest;
import com.etiya.rentACarSpring.business.request.UpdateCarRequest;

public interface CarService {
	void add(CreateCarRequest createCarRequest);

	void update(UpdateCarRequest updateCarRequest);

	void delete(DeleteCarRequest deleteCarRequest);

	List<CarSearchListDto> getAll();
}
