package com.etiya.RentACarSpring.business.abstracts;

import com.etiya.RentACarSpring.business.dtos.CarDetailDto;
import com.etiya.RentACarSpring.business.dtos.CarDto;
import com.etiya.RentACarSpring.business.requests.car.CreateCarRequest;
import com.etiya.RentACarSpring.business.requests.car.DeleteCarRequest;
import com.etiya.RentACarSpring.business.requests.car.UpdateCarRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import com.etiya.RentACarSpring.entities.concretes.Car;

import java.util.List;

public interface CarService  {
	
	
	DataResult<List<CarDto>> getAll();
	
	DataResult<CarDto> getById(int carId);
	
	DataResult<List<CarDetailDto>> getCarWithDetails();

	DataResult<List<Car>> getByBrandId(int brandId);
	
	DataResult<List<Car>> getByColorId(int colorId);
	
	DataResult<List<Car>> getAvailableCars();
	
	DataResult<List<Car>> getByCity(String city);
	
	Result add(CreateCarRequest createCarRequest);
	
	Result update(UpdateCarRequest updateCarRequest);

	Result delete(DeleteCarRequest deleteCarRequest);
	




}
