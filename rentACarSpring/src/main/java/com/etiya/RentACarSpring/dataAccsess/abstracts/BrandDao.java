package com.etiya.RentACarSpring.dataAccsess.abstracts;

import com.etiya.RentACarSpring.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandDao extends JpaRepository<Brand, Integer> {
	
	
	boolean existsBrandByBrandName(String brandName);
	
	
	
}
