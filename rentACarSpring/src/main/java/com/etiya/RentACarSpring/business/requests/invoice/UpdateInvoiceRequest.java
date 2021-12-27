package com.etiya.RentACarSpring.business.requests.invoice;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInvoiceRequest {
	
	private Date rentDate;
	private Date invoiceDate;
	private String invoiceNumber;
	private double invoiceAmount;
	private Long totalRentDay;
	
	private int invoiceId;
	
	private int rentalId;
	
	private int customerId;

}
