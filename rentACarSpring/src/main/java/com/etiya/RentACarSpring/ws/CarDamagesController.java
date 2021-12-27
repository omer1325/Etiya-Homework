package com.etiya.RentACarSpring.ws;

import java.util.List;

import javax.validation.Valid;

import com.etiya.RentACarSpring.business.abstracts.CarDamageService;
import com.etiya.RentACarSpring.business.dtos.CarDamageDto;
import com.etiya.RentACarSpring.business.requests.carDamage.CreateCarDamageRequest;
import com.etiya.RentACarSpring.business.requests.carDamage.DeleteCarDamagesRequest;
import com.etiya.RentACarSpring.business.requests.carDamage.UpdateCarDamageRequest;
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
@RequestMapping("api/car_damages")
public class CarDamagesController {
	
	CarDamageService carDamageService;
	
	@Autowired
	public CarDamagesController(CarDamageService carDamageService) {
		super();
		this.carDamageService = carDamageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CarDamageDto>> getAll() {
		return this.carDamageService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<CarDamageDto>getById(int carDamagesId) {
		return this.carDamageService.getById(carDamagesId);
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCarDamageRequest createCarDamageRequest) {
		return this.carDamageService.add(createCarDamageRequest);
	}

	@PostMapping("update")
	public Result update(@Valid @RequestBody UpdateCarDamageRequest updateCarDamageRequest) {
		return this.carDamageService.update(updateCarDamageRequest);
	}

	@PutMapping("delete")
	public Result delete(@Valid @RequestBody DeleteCarDamagesRequest deleteCarDamageRequest) {
		return this.carDamageService.delete(deleteCarDamageRequest);
	}
	
	
	
	

}
