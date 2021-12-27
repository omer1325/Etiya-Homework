package com.etiya.RentACarSpring.dataAccsess.abstracts;


import com.etiya.RentACarSpring.entities.concretes.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserDao extends JpaRepository<ApplicationUser, Integer>{
	
	boolean existsByEmail(String email);

	ApplicationUser getByEmail(String email);
	

}
