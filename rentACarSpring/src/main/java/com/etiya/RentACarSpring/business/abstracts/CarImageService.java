package com.etiya.RentACarSpring.business.abstracts;

import com.etiya.RentACarSpring.business.dtos.CarImageDto;
import com.etiya.RentACarSpring.business.requests.carImage.CreateCarImageRequest;
import com.etiya.RentACarSpring.business.requests.carImage.DeleteCarImageRequest;
import com.etiya.RentACarSpring.business.requests.carImage.UpdateCarImageRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;

import java.io.IOException;
import java.util.List;

public interface CarImageService {

	DataResult<List<CarImageDto>> getAll();
	
	DataResult<List<CarImageDto>> getImagesWıthCarId (int carId);
	

	Result add(CreateCarImageRequest createCarImageRequest)throws IOException;

	Result update(UpdateCarImageRequest updateCarImageRequest)throws IOException;

	Result delete(DeleteCarImageRequest deleteCarImageRequest);

	

	

}
