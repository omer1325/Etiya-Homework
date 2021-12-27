package com.etiya.RentACarSpring.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.etiya.RentACarSpring.business.abstracts.CarService;
import com.etiya.RentACarSpring.business.constants.Messages;
import com.etiya.RentACarSpring.business.dtos.CarDetailDto;
import com.etiya.RentACarSpring.business.dtos.CarDto;
import com.etiya.RentACarSpring.business.requests.car.CreateCarRequest;
import com.etiya.RentACarSpring.business.requests.car.DeleteCarRequest;
import com.etiya.RentACarSpring.business.requests.car.UpdateCarRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import com.etiya.RentACarSpring.core.results.SuccessDataResult;
import com.etiya.RentACarSpring.core.results.SuccessResult;
import com.etiya.RentACarSpring.dataAccsess.abstracts.CarDao;
import com.etiya.RentACarSpring.dataAccsess.abstracts.CarImageDao;
import com.etiya.RentACarSpring.entities.concretes.Car;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarManager implements CarService {

	private CarDao carDao;
	private ModelMapper modelMapper;

	@Autowired
	public CarManager(CarDao carDao, CarImageDao carImageDao, ModelMapper modelMapper) {
		super();
		this.carDao = carDao;
		this.modelMapper = modelMapper;

	}

	@Override
	public DataResult<List<CarDto>> getAll() {
		List<Car> cars = this.carDao.findAll();
		List<CarDto> carDtos = cars.stream().map(car -> modelMapper.map(car, CarDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<CarDto>>(carDtos, Messages.CARSLIST);

	}

	@Override
	public DataResult<CarDto> getById(int carId) {

		Car cars = this.carDao.getById(carId);
		CarDto carDtos = modelMapper.map(cars, CarDto.class);

		return new SuccessDataResult<CarDto>(carDtos,Messages.CARLIST);

	}

	@Override
	public Result add(CreateCarRequest createCarRequest) {

		Car car = this.modelMapper.map(createCarRequest, Car.class);

		this.carDao.save(car);
		return new SuccessResult(Messages.CARADD);
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {

		Car car = this.modelMapper.map(updateCarRequest, Car.class);

		this.carDao.save(car);
		return new SuccessResult(Messages.CARUPDATE);

	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {
		Car car = this.carDao.getById(deleteCarRequest.getCarId());
		car.setCarId(deleteCarRequest.getCarId());

		this.carDao.delete(car);
		return new SuccessResult(Messages.CARDELETE);

	}

	@Override
	public DataResult<List<CarDetailDto>> getCarWithDetails() {
		return new SuccessDataResult<List<CarDetailDto>>(this.carDao.getCarWithDetails());
	}

	@Override
	public DataResult<List<Car>> getByBrandId(int brandId) {

		return new SuccessDataResult<List<Car>>(this.carDao.getByBrand_BrandId(brandId), Messages.CARLIST);
	}

	@Override
	public DataResult<List<Car>> getByColorId(int colorId) {

		return new SuccessDataResult<List<Car>>(this.carDao.getByColor_ColorId(colorId), Messages.CARLIST);
	}

	@Override
	public DataResult<List<Car>> getAvailableCars() {

		List<Car> cars = this.carDao.findAll();
		List<Car> carsInRepair = this.carDao.findByCarRepair_ReturnStatus(false);
		cars.removeAll(carsInRepair);
		List<Car> rentedCars = this.carDao.findByRentals_ReturnStatus(false);
		cars.removeAll(rentedCars);

		return new SuccessDataResult<List<Car>>(cars, Messages.CARLIST);
	}

	@Override
	public DataResult<List<Car>> getByCity(String city) {
		List<Car> cars = this.carDao.getByCity(city);
		return new SuccessDataResult<List<Car>>(cars, Messages.CARLIST);
	}

}
