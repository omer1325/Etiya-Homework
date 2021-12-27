package com.etiya.RentACarSpring.dataAccsess.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.entities.concretes.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageDao extends JpaRepository<CarImage, Integer>{
	
	List<CarImage> getByCar_CarId(int carId);
	
	CarImage getImagePathByCar_CarId(int carId);
	
	int countCarImageByCar_CarId(int carId);
	

	

	

}
