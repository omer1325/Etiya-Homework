package com.etiya.RentACarSpring.ws;

import java.util.List;

import javax.validation.Valid;

import com.etiya.RentACarSpring.business.abstracts.CarService;
import com.etiya.RentACarSpring.business.dtos.CarDetailDto;
import com.etiya.RentACarSpring.business.dtos.CarDto;
import com.etiya.RentACarSpring.business.requests.car.CreateCarRequest;
import com.etiya.RentACarSpring.business.requests.car.DeleteCarRequest;
import com.etiya.RentACarSpring.business.requests.car.UpdateCarRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import com.etiya.RentACarSpring.entities.concretes.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/cars")
public class CarsController {

	CarService carService;

	@Autowired
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}

	@GetMapping("/getall")
	public DataResult<List<CarDto>> getAll() {
		return this.carService.getAll();
	}
	

	@GetMapping("/getbyid")
	public DataResult<CarDto> getById(int carId) {
		return this.carService.getById(carId);
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCarRequest createCarRequest) {
		return this.carService.add(createCarRequest);
	}
	
	
	@GetMapping("/getcarwithdetails")
	public DataResult<List<CarDetailDto>>getCarWithDetails() {
		return this.carService.getCarWithDetails();
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody UpdateCarRequest updateCarRequest) {
		return this.carService.update(updateCarRequest);
	}

	@PutMapping("/delete")
	public Result delete(DeleteCarRequest deleteCarRequest) {
		return this.carService.delete(deleteCarRequest);
	}
	
	@GetMapping("/getbybrandıd")
	public DataResult<List<Car>>  getByBrandId(int brandId ) {
		return this.carService.getByBrandId(brandId);
	}
	
	@GetMapping("/getbycolorıd")
	public DataResult<List<Car>> getByColorId(int colorId){
		return this.carService.getByColorId(colorId);
		
	}
	
	@GetMapping("/getavailablecars")
	public DataResult<List<Car>> getAvailableCars(){
		return this.carService.getAvailableCars();
		
	}
	
	@GetMapping("/getbycity")
	public DataResult<List<Car>> getByCity(String city){
		return this.carService.getByCity(city);
		
	}
	
	
	

}
