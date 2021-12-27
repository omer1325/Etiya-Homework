package com.etiya.RentACarSpring.ws;
import java.util.List;

import javax.validation.Valid;

import com.etiya.RentACarSpring.business.abstracts.AdditionalServiceService;
import com.etiya.RentACarSpring.business.dtos.AdditionalServiceDetailDto;
import com.etiya.RentACarSpring.business.requests.additionalService.CreateAdditionalServiceRequest;
import com.etiya.RentACarSpring.business.requests.additionalService.DeleteAdditionalServiceRequest;
import com.etiya.RentACarSpring.business.requests.additionalService.UpdateAdditionalServiceRequest;
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
@RequestMapping("/additional_service")
public class AdditionalSevicesController {
	AdditionalServiceService additionalServiceService;

	@Autowired
	public AdditionalSevicesController(AdditionalServiceService additionalServiceService) {
		super();
		this.additionalServiceService = additionalServiceService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateAdditionalServiceRequest createAdditionalServiceRequest) {
		return this.additionalServiceService.add(createAdditionalServiceRequest);
	}

	@PostMapping("update")
	public Result update(@Valid @RequestBody UpdateAdditionalServiceRequest updateAdditionalServiceRequest) {
		return this.additionalServiceService.update(updateAdditionalServiceRequest);
	}

	@PutMapping("delete")
	public Result delete(@Valid @RequestBody DeleteAdditionalServiceRequest deleteAdditionalServiceRequest) {
		return this.additionalServiceService.delete(deleteAdditionalServiceRequest);
	}

	@GetMapping("/getbyid")
	public DataResult<AdditionalServiceDetailDto> getById(int additionalId) {
		return this.additionalServiceService.getById(additionalId);
	}
	
	@GetMapping("/getall")
	public DataResult<List<AdditionalServiceDetailDto>> getAll() {
		return this.additionalServiceService.getAll();
	}
}
