package com.etiya.rentACarSpring.business.abstracts;

import java.util.List;

import com.etiya.rentACarSpring.business.dtos.BrandSearchListDto;
import com.etiya.rentACarSpring.business.request.CreateBrandRequest;
import com.etiya.rentACarSpring.business.request.DeleteBrandRequest;
import com.etiya.rentACarSpring.business.request.UpdateBrandRequest;

public interface BrandService {
	void add(CreateBrandRequest createBrandRequest);

	void update(UpdateBrandRequest updateBrandRequest);

	void delete(DeleteBrandRequest deleteBrandRequest);

	List<BrandSearchListDto> getAll();
}
