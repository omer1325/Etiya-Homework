package com.etiya.RentACarSpring.business.abstracts;

import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.entities.concretes.ApplicationUser;

import java.util.List;

public interface ApplicationUserService {


    DataResult<List<ApplicationUser>> getAll();
	
	
	
}
