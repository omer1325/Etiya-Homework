package com.etiya.RentACarSpring.dataAccsess.abstracts;

import com.etiya.RentACarSpring.entities.concretes.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualCustomerDao extends JpaRepository<IndividualCustomer, Integer> {
	
	IndividualCustomer getByIdentityNumber(String identityNumber);

}
