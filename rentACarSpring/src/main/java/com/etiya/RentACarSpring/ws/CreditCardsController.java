package com.etiya.RentACarSpring.ws;

import java.util.List;

import javax.validation.Valid;

import com.etiya.RentACarSpring.business.abstracts.CreditCardService;
import com.etiya.RentACarSpring.business.dtos.CreditCardDto;
import com.etiya.RentACarSpring.business.requests.creditCard.CreateCreditCardRequest;
import com.etiya.RentACarSpring.business.requests.creditCard.DeleteCreditCardRequest;
import com.etiya.RentACarSpring.business.requests.creditCard.UpdateCreditCardRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/credit_cards")
public class CreditCardsController {

	CreditCardService creditCardService;

	public CreditCardsController(CreditCardService creditCardService) {
		super();
		this.creditCardService = creditCardService;
	}

	@GetMapping("/getall")
	public DataResult<List<CreditCardDto>> getAll() {
		return this.creditCardService.getAll();
	}

	@GetMapping("/getcreditcardbycustomerid")
	public DataResult<List<CreditCardDto>> getCreditCardByCustomerId (int userId) {
		return this.creditCardService.getCreditCardByCustomerId(userId);
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCreditCardRequest createCreditCardRequest) {
		return this.creditCardService.add(createCreditCardRequest);
	}

	@PostMapping("update")
	public Result update(@Valid @RequestBody UpdateCreditCardRequest updateCreditCardRequest) {
		return this.creditCardService.update(updateCreditCardRequest);
	}

	@PutMapping("delete")
	public Result delete(DeleteCreditCardRequest deleteCreditCardRequest) {
		return this.creditCardService.delete(deleteCreditCardRequest);
	}

}
