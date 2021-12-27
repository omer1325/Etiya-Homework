package com.etiya.RentACarSpring.dataAccsess.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.entities.concretes.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CreditCardDao extends JpaRepository<CreditCard, Integer>{
	
	List<CreditCard> getCreditCardByCustomer_UserId(int userId);
	
	
	

}
