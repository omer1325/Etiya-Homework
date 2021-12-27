package com.etiya.RentACarSpring.business.requests.car;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

	private String carName;
	
	private String currentMileage;
	private int carFindeks;

	@Min(1900)
	private int modelYear;
	
	private String city;
	@Min(0)
	private double dailyPrice;

	@Size(max = 200)
	private String description;
	
	private int carId;
	private int brandId;

	private int colorId;
	
	
}
