package com.etiya.RentACarSpring.core.services;

public class FindexPointService {
	
	public int corporateCustomerFindexPoint(String taxNumber) {
		return 750;
	}
	
	public int	individualCustomerFindexPoint(String identityNumber) {
		return 750;
	}
}
