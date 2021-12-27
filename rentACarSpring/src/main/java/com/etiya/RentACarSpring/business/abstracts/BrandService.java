package com.etiya.RentACarSpring.business.abstracts;

import com.etiya.RentACarSpring.business.dtos.BrandDto;
import com.etiya.RentACarSpring.business.requests.brand.CreateBrandRequest;
import com.etiya.RentACarSpring.business.requests.brand.DeleteBrandRequest;
import com.etiya.RentACarSpring.business.requests.brand.UpdateBrandRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;

import java.util.List;

public interface BrandService {
	
	DataResult<List<BrandDto>> getAll();
	
	DataResult<BrandDto> getById(int brandId);

	Result add(CreateBrandRequest createBrandRequest);
	
	Result update(UpdateBrandRequest updateBrandRequest);
	
	Result delete(DeleteBrandRequest deleteBrandRequest);
	

	

}
