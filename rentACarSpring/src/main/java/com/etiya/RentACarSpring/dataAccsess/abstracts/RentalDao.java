package com.etiya.RentACarSpring.dataAccsess.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.business.dtos.RentalDetailsDto;
import com.etiya.RentACarSpring.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RentalDao extends JpaRepository<Rental, Integer> {

	@Query("Select new com.etiya.RentACarSpring.business.dtos.RentalDetailsDto" + "(c.carId, r.returnDate) "
			+ "From Car c Inner Join c.rentals r where c.carId=:carId and r.returnDate is null")
	RentalDetailsDto getByCarIdWhereReturnDateIsNull(int carId);

	List<Rental> getByCar_CarId(int carId);
	
	

}
