package com.etiya.RentACarSpring.business.requests.carImage;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarImageRequest {
	
	@NotNull
	private int carId;
	
	private String imageName;
	
	@JsonIgnore
	private MultipartFile file;
	
	
	
	

}
