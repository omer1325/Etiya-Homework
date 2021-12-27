package com.etiya.RentACarSpring.ws;

import java.util.List;

import javax.validation.Valid;

import com.etiya.RentACarSpring.business.abstracts.CorporateCustomerService;
import com.etiya.RentACarSpring.business.dtos.CorporateCustomerDto;
import com.etiya.RentACarSpring.business.requests.corporateCustomer.CreateCorporateCustomerRequest;
import com.etiya.RentACarSpring.business.requests.corporateCustomer.DeleteCorporateCustomerRequest;
import com.etiya.RentACarSpring.business.requests.corporateCustomer.UpdateCorporateCustomerRequest;
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
@RequestMapping("/corporatecustomers")
public class CorporateCustomersController {
	
	private CorporateCustomerService corporateCustomerService;
	
	@Autowired
	public CorporateCustomersController(CorporateCustomerService corporateCustomerService) {
		this.corporateCustomerService=corporateCustomerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CorporateCustomerDto>> getAll() {
		return this.corporateCustomerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCorporateCustomerRequest createCorporateCustomerRequest) {
		return this.corporateCustomerService.add(createCorporateCustomerRequest);
	}

	@PostMapping("update")
	public Result update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
		return this.corporateCustomerService.update(updateCorporateCustomerRequest);
	}

	@PutMapping("delete")
	public Result delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest) {
		return this.corporateCustomerService.delete(deleteCorporateCustomerRequest);
	}

}
