package com.etiya.RentACarSpring.business.requests.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLoginRequest {
	
	private String email;
	private String password;

}
