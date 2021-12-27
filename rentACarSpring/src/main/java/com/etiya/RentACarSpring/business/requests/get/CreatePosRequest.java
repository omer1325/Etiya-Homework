package com.etiya.RentACarSpring.business.requests.get;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePosRequest {
	
	
	private String cardNumber;
	
	private String cvc;
	
	private String pullDate;
	
	private String cardName;
	
	private double price;
	
	
	
	

}
