package com.etiya.RentACarSpring.dataAccsess.abstracts;

import com.etiya.RentACarSpring.entities.abstracts.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	
	boolean existsCustomerByEmail(String email);


	
	

}
