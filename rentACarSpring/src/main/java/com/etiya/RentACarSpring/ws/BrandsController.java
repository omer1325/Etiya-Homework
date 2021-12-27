package com.etiya.RentACarSpring.ws;

import java.util.List;

import javax.validation.Valid;

import com.etiya.RentACarSpring.business.abstracts.BrandService;
import com.etiya.RentACarSpring.business.dtos.BrandDto;
import com.etiya.RentACarSpring.business.requests.brand.CreateBrandRequest;
import com.etiya.RentACarSpring.business.requests.brand.DeleteBrandRequest;
import com.etiya.RentACarSpring.business.requests.brand.UpdateBrandRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/brands")
public class BrandsController {

	BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		super();
		this.brandService = brandService;
	}

	@GetMapping("/getall")
	public DataResult<List<BrandDto>> getAll() {
		return this.brandService.getAll();
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateBrandRequest createBrandRequest) {
		return this.brandService.add(createBrandRequest);
	}

	@GetMapping("/getbyid")
	public DataResult<BrandDto> getById(int brandId) {
		return this.brandService.getById(brandId);
	}

	@PostMapping("update")
	public Result update(UpdateBrandRequest updateBrandRequest) {
		return this.brandService.update(updateBrandRequest);
	}

	@PutMapping("delete")
	public Result delete(DeleteBrandRequest deleteBrandRequest) {
		return this.brandService.delete(deleteBrandRequest);
	}

}
