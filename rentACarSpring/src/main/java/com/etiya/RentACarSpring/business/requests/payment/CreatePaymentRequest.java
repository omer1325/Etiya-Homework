package com.etiya.RentACarSpring.business.requests.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {

	private String cardName;
	
	private String cardNumber;
	
	private String pullDate;
	
	private String cvc;
	
	
	private double price;


}
