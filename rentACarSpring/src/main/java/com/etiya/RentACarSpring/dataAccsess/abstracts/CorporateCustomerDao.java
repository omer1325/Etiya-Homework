package com.etiya.RentACarSpring.dataAccsess.abstracts;

import com.etiya.RentACarSpring.entities.concretes.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateCustomerDao extends JpaRepository<CorporateCustomer, Integer>{
	
	CorporateCustomer getByTaxNumber(String taxNumber);

}
