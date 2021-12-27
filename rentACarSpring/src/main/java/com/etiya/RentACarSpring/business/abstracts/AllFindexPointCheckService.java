package com.etiya.RentACarSpring.business.abstracts;


import com.etiya.RentACarSpring.entities.concretes.CorporateCustomer;
import com.etiya.RentACarSpring.entities.concretes.IndividualCustomer;

public interface AllFindexPointCheckService {
	
 int checkCorporateCustomerFindexPoint(CorporateCustomer corporateCustomer);
 int checkIndividualCustomerFindexPoint(IndividualCustomer individualCustomer);
	

}
