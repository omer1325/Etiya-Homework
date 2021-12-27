package com.etiya.RentACarSpring.ws;

import java.util.List;

import javax.validation.Valid;

import com.etiya.RentACarSpring.business.abstracts.CarRepairService;
import com.etiya.RentACarSpring.business.dtos.CarRepairsDto;
import com.etiya.RentACarSpring.business.requests.carRepair.CreateCarRepairRequest;
import com.etiya.RentACarSpring.business.requests.carRepair.DeleteCarRepairRequest;
import com.etiya.RentACarSpring.business.requests.carRepair.UpdateCarRepairRequest;
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
@RequestMapping("api/car_repairs")
public class CarRepairsController {
	
	CarRepairService carRepairService;

	@Autowired
	public CarRepairsController(CarRepairService carRepairService) {
		
		this.carRepairService = carRepairService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CarRepairsDto>> getAll() {
		return this.carRepairService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<CarRepairsDto> getById(int carRepairId) {
		return this.carRepairService.getById(carRepairId);
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCarRepairRequest createCarRepairRequest) {
		return this.carRepairService.add(createCarRepairRequest);
	}
	
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody UpdateCarRepairRequest updateCarRepairRequest) {
		return this.carRepairService.update(updateCarRepairRequest);
	}

	@PutMapping("/delete")
	public Result delete(DeleteCarRepairRequest deleteCarRepairRequest) {
		return this.carRepairService.delete(deleteCarRepairRequest);
	}
	
	

}
