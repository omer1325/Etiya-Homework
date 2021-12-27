package com.etiya.RentACarSpring.business.abstracts;


import com.etiya.RentACarSpring.business.requests.get.CreateLoginRequest;
import com.etiya.RentACarSpring.core.results.Result;

public interface AuthenticationService {
	
	Result logIn(CreateLoginRequest createLoginRequest);
}
