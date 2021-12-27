package com.etiya.RentACarSpring.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "additional_service")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class AdditionalService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "additional_id")
	private int additionalId;

	@Column(name = "additional_description")
	private String additionalDescription;

	@Column(name = "additional_price")
	private double additionalPrice;

	@Column(name = "additional_name")
	private String additionalName;
	
	
	@ManyToMany(mappedBy = "additionalServices")
	private List <Rental> rentals;
	
	
	
	
	

	
	
}
