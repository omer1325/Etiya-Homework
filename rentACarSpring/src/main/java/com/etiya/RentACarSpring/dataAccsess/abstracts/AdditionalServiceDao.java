package com.etiya.RentACarSpring.dataAccsess.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.entities.concretes.AdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;




public interface AdditionalServiceDao extends JpaRepository<AdditionalService, Integer> {

	boolean existsAdditionalServiceByAdditionalName(String additionalName);
	
	List<AdditionalService> getByRentals_RentalId(int rentalId);
	

	

}
