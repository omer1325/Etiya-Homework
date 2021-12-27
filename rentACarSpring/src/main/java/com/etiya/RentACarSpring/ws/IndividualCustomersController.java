package com.etiya.RentACarSpring.ws;

import java.util.List;

import javax.validation.Valid;

import com.etiya.RentACarSpring.business.abstracts.IndividualCustomerService;
import com.etiya.RentACarSpring.business.dtos.IndividualCustomerDto;
import com.etiya.RentACarSpring.business.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.RentACarSpring.business.requests.individualCustomer.DeleteIndividualCustomerRequest;
import com.etiya.RentACarSpring.business.requests.individualCustomer.UpdateIndividualCustomerRequest;
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
@RequestMapping("/individualcustomers")
public class IndividualCustomersController {

	private IndividualCustomerService individualCustomerService;

	@Autowired
	public IndividualCustomersController(IndividualCustomerService individualCustomerService) {
		super();
		this.individualCustomerService = individualCustomerService;
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<IndividualCustomerDto>> getAll() {
		return this.individualCustomerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) {
		return this.individualCustomerService.add(createIndividualCustomerRequest);
	}

	@PostMapping("update")
	public Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
		return this.individualCustomerService.update(updateIndividualCustomerRequest);
	}

	@PutMapping("delete")
	public Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
		return this.individualCustomerService.delete(deleteIndividualCustomerRequest);
	}


}
