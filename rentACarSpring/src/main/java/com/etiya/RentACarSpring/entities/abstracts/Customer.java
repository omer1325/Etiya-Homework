package com.etiya.RentACarSpring.entities.abstracts;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.etiya.RentACarSpring.entities.concretes.ApplicationUser;
import com.etiya.RentACarSpring.entities.concretes.CreditCard;
import com.etiya.RentACarSpring.entities.concretes.Invoice;
import com.etiya.RentACarSpring.entities.concretes.Rental;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler","rentals"})
@Table(name="customers")

public class Customer extends ApplicationUser {
	
	
	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<CreditCard> creditCards;
	
    @JsonIgnore
    @OneToMany(mappedBy="customer")
    private List<Rental> rentals;
    
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Invoice> invoices;
    

   
    

}
