package com.etiya.RentACarSpring.business.abstracts;

import com.etiya.RentACarSpring.business.dtos.ColorDto;
import com.etiya.RentACarSpring.business.requests.color.CreateColorRequest;
import com.etiya.RentACarSpring.business.requests.color.DeleteColorRequest;
import com.etiya.RentACarSpring.business.requests.color.UpdateColorRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import com.etiya.RentACarSpring.entities.concretes.Color;

import java.util.List;

public interface ColorService {
	
	DataResult<List<ColorDto>> getAll();
	
	DataResult<ColorDto> getById(int colorId);
	
	DataResult<List<Color>> getByCarId(int carId);
	
	Result add(CreateColorRequest createColorRequest);
	
	Result update(UpdateColorRequest updateColorRequest);
	
	Result delete(DeleteColorRequest deleteColorRequest);

}
 