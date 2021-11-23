package com.etiya.rentACarSpring.business.abstracts;

import java.util.List;

import com.etiya.rentACarSpring.business.dtos.ColorSearchListDto;
import com.etiya.rentACarSpring.business.request.CreateColorRequest;
import com.etiya.rentACarSpring.business.request.DeleteColorRequest;
import com.etiya.rentACarSpring.business.request.UpdateColorRequest;

public interface ColorService {
	void add(CreateColorRequest createColorRequest);

	void update(UpdateColorRequest updateColorRequest);

	void delete(DeleteColorRequest deleteColorRequest);

	List<ColorSearchListDto> getAll();
}
