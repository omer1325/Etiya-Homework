package com.etiya.RentACarSpring.business.abstracts;


import com.etiya.RentACarSpring.business.dtos.PaymentDto;
import com.etiya.RentACarSpring.business.requests.payment.CreatePaymentRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;

public interface PaymentService {
	
	DataResult<PaymentDto> getById(int paymentId);

	Result add(CreatePaymentRequest createPaymentRequest);
	
	
}
