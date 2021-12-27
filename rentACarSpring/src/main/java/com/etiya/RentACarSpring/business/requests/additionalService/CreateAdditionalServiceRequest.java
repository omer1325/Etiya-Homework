package com.etiya.RentACarSpring.business.requests.additionalService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdditionalServiceRequest {
	
	
	private String additionalDescription;
	
	private double additionalPrice;

	private String additionalName;

}
