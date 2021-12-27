package com.etiya.RentACarSpring.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.etiya.RentACarSpring.business.abstracts.AdditionalServiceService;
import com.etiya.RentACarSpring.business.constants.Messages;
import com.etiya.RentACarSpring.business.dtos.AdditionalServiceDetailDto;
import com.etiya.RentACarSpring.business.requests.additionalService.CreateAdditionalServiceRequest;
import com.etiya.RentACarSpring.business.requests.additionalService.DeleteAdditionalServiceRequest;
import com.etiya.RentACarSpring.business.requests.additionalService.UpdateAdditionalServiceRequest;
import com.etiya.RentACarSpring.core.business.BusinessRules;
import com.etiya.RentACarSpring.core.results.*;
import com.etiya.RentACarSpring.dataAccsess.abstracts.AdditionalServiceDao;
import com.etiya.RentACarSpring.entities.concretes.AdditionalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdditionalServiceManager implements AdditionalServiceService {

	AdditionalServiceDao additionalServiceDao;
	private ModelMapper modelMapper;

	@Autowired
	public AdditionalServiceManager(AdditionalServiceDao additionalServiceDao, ModelMapper modelMapper) {
		super();
		this.additionalServiceDao = additionalServiceDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest) {

		var result = BusinessRules
				.run(checkAdditionalServiceDupplicateName(createAdditionalServiceRequest.getAdditionalName()));

		if (result != null) {
			return result;
		}

		AdditionalService additionalService = new AdditionalService();
		additionalService.setAdditionalName(createAdditionalServiceRequest.getAdditionalName());
		additionalService.setAdditionalDescription(createAdditionalServiceRequest.getAdditionalDescription());
		additionalService.setAdditionalPrice(createAdditionalServiceRequest.getAdditionalPrice());

		this.additionalServiceDao.save(additionalService);
		return new SuccessResult(Messages.ADDITIONALSERVICEADD);
	}

	@Override
	public Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest) {

		var result = BusinessRules
				.run(checkAdditionalServiceDupplicateName(updateAdditionalServiceRequest.getAdditionalName()));

		if (result != null) {
			return result;
		}

		AdditionalService additionalService = this.additionalServiceDao
				.getById(updateAdditionalServiceRequest.getAdditionalId());
		additionalService.setAdditionalName(updateAdditionalServiceRequest.getAdditionalName());
		additionalService.setAdditionalDescription(updateAdditionalServiceRequest.getAdditionalDescription());
		additionalService.setAdditionalPrice(updateAdditionalServiceRequest.getAdditionalPrice());

		this.additionalServiceDao.save(additionalService);
		return new SuccessResult(Messages.ADDITIONALSERVICEUPDATE);
	}

	@Override
	public Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequest) {
		AdditionalService additionalService = this.additionalServiceDao
				.getById(deleteAdditionalServiceRequest.getAdditionalId());

		this.additionalServiceDao.delete(additionalService);
		return new SuccessResult(Messages.ADDITIONALSERVICEDELETE);
	}

	private Result checkAdditionalServiceDupplicateName(String additionalName) {
		if (this.additionalServiceDao.existsAdditionalServiceByAdditionalName(additionalName)) {
			return new ErrorResult();
		}
		return new SuccessResult(Messages.SUCCESS);
	}

	@Override
	public DataResult<AdditionalServiceDetailDto> getById(int additionalId) {

		AdditionalService additionalService = this.additionalServiceDao.getById(additionalId);
		AdditionalServiceDetailDto additionalServicesDtos = modelMapper.map(additionalService,
				AdditionalServiceDetailDto.class);

		return new SuccessDataResult<AdditionalServiceDetailDto>(additionalServicesDtos,Messages.ADDITIONALSERVICELIST);

	}

	@Override
	public DataResult<List<AdditionalServiceDetailDto>> getAll() {
		List<AdditionalService> additionalServices = this.additionalServiceDao.findAll();
		List<AdditionalServiceDetailDto> additionalServicesDtos = additionalServices.stream()
				.map(additionalService -> modelMapper.map(additionalService, AdditionalServiceDetailDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<AdditionalServiceDetailDto>>(additionalServicesDtos,Messages.ADDITIONALSERVICELIST);

	}

	@Override
	public DataResult<List<AdditionalServiceDetailDto>> getByRentalId(int rentalId) {
		List<AdditionalService> additionalServices = this.additionalServiceDao.getByRentals_RentalId(rentalId);
		List<AdditionalServiceDetailDto> additionalServiceDetailDto = additionalServices.stream()
				.map(additionalService -> modelMapper.map(additionalService, AdditionalServiceDetailDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<AdditionalServiceDetailDto>>(additionalServiceDetailDto);
	}
}
