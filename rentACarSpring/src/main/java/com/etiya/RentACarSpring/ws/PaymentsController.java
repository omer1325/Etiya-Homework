package com.etiya.RentACarSpring.ws;

import javax.validation.Valid;

import com.etiya.RentACarSpring.business.abstracts.PaymentService;
import com.etiya.RentACarSpring.business.dtos.PaymentDto;
import com.etiya.RentACarSpring.business.requests.payment.CreatePaymentRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {
	
	private PaymentService paymentService;

	public PaymentsController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreatePaymentRequest createPaymentRequest) {
		return this.paymentService.add(createPaymentRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<PaymentDto> getById(int paymentId) {
		return this.paymentService.getById(paymentId);
	}
	

}
