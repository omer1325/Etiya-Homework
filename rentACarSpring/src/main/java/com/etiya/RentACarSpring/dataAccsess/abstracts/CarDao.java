package com.etiya.RentACarSpring.dataAccsess.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.business.dtos.CarDetailDto;
import com.etiya.RentACarSpring.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarDao extends JpaRepository<Car, Integer> {

	@Query("Select new com.etiya.RentACarSpring.business.dtos.CarDetailDto"
			+ " (c.carName, b.brandName , col.colorName, c.dailyPrice) " 
			+ " From Brand b Inner Join b.cars c"
			+ " Inner Join c.color col")
	
	List<CarDetailDto> getCarWithDetails();
	
	List<Car> getByBrand_BrandId(int brandId);
	
	List<Car> getByColor_ColorId(int colorId);
	
	List<Car> findByCarRepair_ReturnStatus(boolean returnStatus);
	
	List<Car> findByRentals_ReturnStatus(boolean returnStatus);
	
	List<Car>getByCity(String city);

	Car getByCarName(String carName);

	@Query ("SELECT c.carFindeks FROM Car c WHERE carId=:carId")
	int getFindeksPointByCar_CarId(int carId);
	
	

}

