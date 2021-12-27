package com.etiya.RentACarSpring.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.etiya.RentACarSpring.business.abstracts.BrandService;
import com.etiya.RentACarSpring.business.constants.Messages;
import com.etiya.RentACarSpring.business.dtos.BrandDto;
import com.etiya.RentACarSpring.business.requests.brand.CreateBrandRequest;
import com.etiya.RentACarSpring.business.requests.brand.DeleteBrandRequest;
import com.etiya.RentACarSpring.business.requests.brand.UpdateBrandRequest;
import com.etiya.RentACarSpring.core.business.BusinessRules;
import com.etiya.RentACarSpring.core.results.*;
import com.etiya.RentACarSpring.dataAccsess.abstracts.BrandDao;
import com.etiya.RentACarSpring.entities.concretes.Brand;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BrandManager implements BrandService {
	
	
	private BrandDao brandDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public BrandManager(BrandDao brandDao,ModelMapper modelMapper) {
		super();
		this.brandDao = brandDao;
		this.modelMapper=modelMapper;
	}

	@Override
	public DataResult<List<BrandDto>> getAll() {
		List<Brand> brands= this.brandDao.findAll();
		List<BrandDto> brandDtos=brands.stream().map(brand -> modelMapper.map(brand, BrandDto.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<BrandDto>>(brandDtos, Messages.BRANDSLIST);
	}

	@Override
	public DataResult<BrandDto> getById(int brandId) {
		Brand brand= this.brandDao.getById(brandId);
	    BrandDto brandDtos=modelMapper.map(brand, BrandDto.class);
		
		return new SuccessDataResult<BrandDto>(brandDtos,Messages.BRANDLIST);
	}
	
	@Override
	public Result add(CreateBrandRequest createBrandRequest) {
		
		var result = BusinessRules.run(checkBrandNameDuplication(createBrandRequest.getBrandName()));

		if (result != null) {
			return result;
		}
		
		Brand brand=new Brand();
		brand.setBrandName(createBrandRequest.getBrandName());
		
		this.brandDao.save(brand);
		return new SuccessResult(Messages.BRANDADD);
		
	}

	@Override
	public Result update(UpdateBrandRequest updateBrandRequest) {
		
		Brand brand = new Brand();
		brand.setBrandId(updateBrandRequest.getBrandId());
		brand.setBrandName(updateBrandRequest.getBrandName());
		
		this.brandDao.save(brand);
		return new SuccessResult(Messages.BRANDUPDATE);
		
	}

	@Override
	public Result delete(DeleteBrandRequest deleteBrandRequest) {
		Brand brand= this.brandDao.getById(deleteBrandRequest.getBrandId());
		
		this.brandDao.delete(brand);
		return new SuccessResult(Messages.BRANDDELETE);
		
	}

	
	
	public Result checkBrandNameDuplication(String brandName) {
		
		if (this.brandDao.existsBrandByBrandName(brandName)) {
			return new ErrorResult(Messages.BRANDNAMEERROR);
		}

		return new SuccessResult();
	}

}
