package com.etiya.RentACarSpring.dataAccsess.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.entities.concretes.CarRepair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepairDao extends JpaRepository<CarRepair, Integer> {
	
	List<CarRepair> getByCar_CarId(int carId);

}
