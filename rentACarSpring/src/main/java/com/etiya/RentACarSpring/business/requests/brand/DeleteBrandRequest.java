package com.etiya.RentACarSpring.business.requests.brand;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeleteBrandRequest {
	
	@NotNull
	@NotBlank
	private int brandId;

}
