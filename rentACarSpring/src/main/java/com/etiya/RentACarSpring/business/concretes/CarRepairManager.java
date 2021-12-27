package com.etiya.RentACarSpring.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.etiya.RentACarSpring.business.abstracts.CarRepairService;
import com.etiya.RentACarSpring.business.constants.Messages;
import com.etiya.RentACarSpring.business.dtos.CarRepairsDto;
import com.etiya.RentACarSpring.business.requests.carRepair.CreateCarRepairRequest;
import com.etiya.RentACarSpring.business.requests.carRepair.DeleteCarRepairRequest;
import com.etiya.RentACarSpring.business.requests.carRepair.UpdateCarRepairRequest;
import com.etiya.RentACarSpring.core.business.BusinessRules;
import com.etiya.RentACarSpring.core.results.*;
import com.etiya.RentACarSpring.dataAccsess.abstracts.CarRepairDao;
import com.etiya.RentACarSpring.dataAccsess.abstracts.RentalDao;
import com.etiya.RentACarSpring.entities.concretes.Car;
import com.etiya.RentACarSpring.entities.concretes.CarRepair;
import com.etiya.RentACarSpring.entities.concretes.Rental;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarRepairManager implements CarRepairService {

	private CarRepairDao carRepairDao;
	private RentalDao rentalDao;
	private ModelMapper modelMapper;

	@Autowired
	public CarRepairManager(CarRepairDao carRepairDao, RentalDao rentalDao, ModelMapper modelMapper) {
		super();
		this.carRepairDao = carRepairDao;
		this.rentalDao = rentalDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<CarRepairsDto> getById(int carRepairId) {
		CarRepair carRepair = this.carRepairDao.getById(carRepairId);
		CarRepairsDto carRepairsDtos = modelMapper.map(carRepair, CarRepairsDto.class);

		return new SuccessDataResult<CarRepairsDto>(carRepairsDtos);
	}

	@Override
	public DataResult<List<CarRepairsDto>> getAll() {
		List<CarRepair> carRepairs = this.carRepairDao.findAll();
		List<CarRepairsDto> carRepairsDtos = carRepairs.stream()
				.map(carRepair -> modelMapper.map(carRepair, CarRepairsDto.class)).collect(Collectors.toList());

		return new SuccessDataResult<List<CarRepairsDto>>(carRepairsDtos);
	}

	@Override
	public Result add(CreateCarRepairRequest createCarRepairRequest) {

		var result = BusinessRules.run(checkIfCarRented(createCarRepairRequest.getCarId()));

		if (result != null) {
			return result;
		}

		CarRepair carRepair = this.modelMapper.map(createCarRepairRequest, CarRepair.class);

		this.carRepairDao.save(carRepair);

		return new SuccessResult(Messages.REPAIRADD);

	}

	@Override
	public Result update(UpdateCarRepairRequest updateCarRepairRequest) {

		Car car = new Car();
		car.setCarId(updateCarRepairRequest.getCarId());

		CarRepair carRepair = this.carRepairDao.getById(updateCarRepairRequest.getCarRepairId());
		carRepair.setRepairDate(updateCarRepairRequest.getRepairDate());
		carRepair.setRepairDescription(updateCarRepairRequest.getRepairDescription());
		carRepair.setReturnStatus(updateCarRepairRequest.isReturnStatus());
		carRepair.setReturnDate(updateCarRepairRequest.getReturnDate());
		carRepair.setRepairPrice(updateCarRepairRequest.getRepairPrice());
		carRepair.setCar(car);

		this.carRepairDao.save(carRepair);

		return new SuccessResult(Messages.REPAIRUPDATE);

	}

	@Override
	public Result delete(DeleteCarRepairRequest deleteCarRepairRequest) {
		CarRepair carRepair = this.carRepairDao.getById(deleteCarRepairRequest.getCarRepairId());

		this.carRepairDao.delete(carRepair);
		return new SuccessResult(Messages.REPAIRDELETE);

	}

	private Result checkIfCarRented(int carId) {

		if (this.rentalDao.getByCar_CarId(carId).size() != 0) {
			Rental rental = this.rentalDao.getByCar_CarId(carId).get(this.rentalDao.getByCar_CarId(carId).size() - 1);

			if (rental.getReturnDate() == null) {
				return new ErrorResult(Messages.ERROR);
			}
		}
		return new SuccessResult();
	}
}
