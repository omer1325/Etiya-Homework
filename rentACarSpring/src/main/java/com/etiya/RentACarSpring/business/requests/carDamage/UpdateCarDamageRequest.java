package com.etiya.RentACarSpring.business.requests.carDamage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarDamageRequest {
	
	private int carDamagesId;
	
	private int carId;
	
	private String damageDescription;

}
