package com.etiya.RentACarSpring.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.etiya.RentACarSpring.business.abstracts.CarDamageService;
import com.etiya.RentACarSpring.business.constants.Messages;
import com.etiya.RentACarSpring.business.dtos.CarDamageDto;
import com.etiya.RentACarSpring.business.requests.carDamage.CreateCarDamageRequest;
import com.etiya.RentACarSpring.business.requests.carDamage.DeleteCarDamagesRequest;
import com.etiya.RentACarSpring.business.requests.carDamage.UpdateCarDamageRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import com.etiya.RentACarSpring.core.results.SuccessDataResult;
import com.etiya.RentACarSpring.core.results.SuccessResult;
import com.etiya.RentACarSpring.dataAccsess.abstracts.CarDamageDao;
import com.etiya.RentACarSpring.dataAccsess.abstracts.CarDao;
import com.etiya.RentACarSpring.entities.concretes.Car;
import com.etiya.RentACarSpring.entities.concretes.CarDamage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarDamageManager implements CarDamageService {

	private CarDamageDao carDamageDao;
	private CarDao carDao;
	private ModelMapper modelMapper;

	@Autowired
	public CarDamageManager(CarDamageDao carDamageDao, CarDao carDao, ModelMapper modelMapper) {
		super();
		this.carDamageDao = carDamageDao;
		this.carDao = carDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<CarDamageDto>> getAll() {
		List<CarDamage> carDamages = this.carDamageDao.findAll();
		List<CarDamageDto> carDamageDtos = carDamages.stream()
				.map(carDamage -> modelMapper.map(carDamage, CarDamageDto.class)).collect(Collectors.toList());

		return new SuccessDataResult<List<CarDamageDto>>(carDamageDtos, Messages.CARDAMAGESLIST);

	}

	@Override
	public DataResult<CarDamageDto> getById(int carDamagesId) {

		CarDamage carDamage = this.carDamageDao.getById(carDamagesId);
		CarDamageDto carDamageDtos = modelMapper.map(carDamage, CarDamageDto.class);

		return new SuccessDataResult<CarDamageDto>(carDamageDtos, Messages.CARDAMAGELIST);

	}

	@Override
	public Result add(CreateCarDamageRequest createCarDamageRequest) {
		Car car = this.carDao.getById(createCarDamageRequest.getCarId());

		CarDamage carDamage = new CarDamage();
		carDamage.setDamageDescription(createCarDamageRequest.getDamageDescription());

		carDamage.setCar(car);
		this.carDamageDao.save(carDamage);

		return new SuccessResult(Messages.CARDAMAGEADD);

	}

	@Override
	public Result update(UpdateCarDamageRequest updateCarDamageRequest) {
		Car car = this.carDao.getById(updateCarDamageRequest.getCarId());

		CarDamage carDamage = new CarDamage();
		carDamage.setDamageDescription(updateCarDamageRequest.getDamageDescription());

		carDamage.setCar(car);
		this.carDamageDao.save(carDamage);

		return new SuccessResult(Messages.CARDAMAGEUPDATE);
	}

	@Override
	public Result delete(DeleteCarDamagesRequest deleteCarDamagesRequest) {
		CarDamage carDamage = this.carDamageDao.getById(deleteCarDamagesRequest.getCarDamagesId());

		this.carDamageDao.delete(carDamage);

		return new SuccessResult(Messages.CARDAMAGEDELETE);

	}

}
