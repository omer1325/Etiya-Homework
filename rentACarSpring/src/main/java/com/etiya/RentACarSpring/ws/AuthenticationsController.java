package com.etiya.RentACarSpring.ws;

import com.etiya.RentACarSpring.business.abstracts.AuthenticationService;
import com.etiya.RentACarSpring.core.results.Result;
import com.etiya.RentACarSpring.business.requests.get.CreateLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/authentication")
public class AuthenticationsController {
	
	AuthenticationService authenticationService;
	
	@Autowired
	public AuthenticationsController(AuthenticationService authenticationService) {
		this.authenticationService=authenticationService;	
	}
	
	@PostMapping("/logIn")
	public Result logIn(CreateLoginRequest createLoginRequest) {
		return this.authenticationService.logIn(createLoginRequest);
		
	}

}
