package com.etiya.RentACarSpring.ws;

import java.util.List;

import com.etiya.RentACarSpring.business.abstracts.ApplicationUserService;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.entities.concretes.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class ApplicationUsersController {
	
	@Autowired
	private ApplicationUserService applicationUserService;
	
	
	public ApplicationUsersController(ApplicationUserService applicationUserService) {
		
		this.applicationUserService=applicationUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ApplicationUser>> getAll() {
		return this.applicationUserService.getAll();
		
	}

}
