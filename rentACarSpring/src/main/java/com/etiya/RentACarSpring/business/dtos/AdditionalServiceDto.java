package com.etiya.RentACarSpring.business.dtos;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalServiceDto {
	
	private int additionalId;
	
	@JsonIgnore
	private double additionalPrice;
	

	
	
	
	
	

}
