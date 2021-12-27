package com.etiya.RentACarSpring.business.abstracts;

import com.etiya.RentACarSpring.business.dtos.CarRepairsDto;
import com.etiya.RentACarSpring.business.requests.carRepair.CreateCarRepairRequest;
import com.etiya.RentACarSpring.business.requests.carRepair.DeleteCarRepairRequest;
import com.etiya.RentACarSpring.business.requests.carRepair.UpdateCarRepairRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;

import java.util.List;


	public interface CarRepairService {
	
	DataResult<CarRepairsDto> getById(int carRepairId);
	
	DataResult<List<CarRepairsDto>> getAll();
	
	Result add(CreateCarRepairRequest createCarRepairRequest);
	
	Result update(UpdateCarRepairRequest updateCarRepairRequest);

	Result delete(DeleteCarRepairRequest deleteCarRepairRequest);
	

}
