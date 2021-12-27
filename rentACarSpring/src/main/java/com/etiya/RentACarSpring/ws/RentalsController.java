package com.etiya.RentACarSpring.ws;

import java.util.List;

import javax.validation.Valid;

import com.etiya.RentACarSpring.business.abstracts.RentalService;
import com.etiya.RentACarSpring.business.dtos.RentalDto;
import com.etiya.RentACarSpring.business.requests.rental.CreateRentalRequest;
import com.etiya.RentACarSpring.business.requests.rental.UpdateRentalRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {

	RentalService rentalService;

	@Autowired
	public RentalsController(RentalService rentalService) {
		super();
		this.rentalService = rentalService;
	}

	@PostMapping("/addindividualcustomer")
	public Result addIndividualCustomer(@Valid @RequestBody CreateRentalRequest createRentalRequest) {
		return this.rentalService.addIndividualCustomer(createRentalRequest);

	}

	@PostMapping("/addcorporatecustomer")
	public Result addCorporateCustomer(@Valid @RequestBody CreateRentalRequest createRentalRequest) {
		return this.rentalService.addCorporateCustomer(createRentalRequest);

	}
	
	@GetMapping("/getall")
	public DataResult<List<RentalDto>> getAll() {
		return this.rentalService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<RentalDto> getById(int rentalId) {
		return this.rentalService.getById(rentalId);
	}

	@PostMapping("/updateindividualcustomer")
	public Result updateIndividualCustomer(@Valid @RequestBody UpdateRentalRequest updateRentalRequest) {
		return this.rentalService.updateIndividualCustomer(updateRentalRequest);

	}

	@PostMapping("/updatecorporatecustomer")
	public Result updateCorporateCustomer(@Valid @RequestBody  UpdateRentalRequest updateRentalRequest) {
		return this.rentalService.updateCorporateCustomer(updateRentalRequest);

	}

}
