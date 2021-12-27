package com.etiya.RentACarSpring.dataAccsess.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.entities.concretes.CarDamage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDamageDao extends JpaRepository<CarDamage, Integer>{
	
	List<CarDamage> getByCar_CarId(int carId);

}
