package com.etiya.RentACarSpring.dataAccsess.abstracts;

import com.etiya.RentACarSpring.entities.concretes.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorDao extends JpaRepository<Color,Integer> {

	Color getByColorName(String colorName);
	
}
