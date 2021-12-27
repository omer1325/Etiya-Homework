package com.etiya.RentACarSpring.core.services;


import com.etiya.RentACarSpring.business.abstracts.AllFindexPointCheckService;
import com.etiya.RentACarSpring.entities.concretes.CorporateCustomer;
import com.etiya.RentACarSpring.entities.concretes.IndividualCustomer;
import org.springframework.stereotype.Service;

@Service
public class FindexPointServiceAdapter implements AllFindexPointCheckService {

	@Override
	public int checkCorporateCustomerFindexPoint(CorporateCustomer corporateCustomer) {
		FindexPointService findexPointService= new FindexPointService();
		return findexPointService.corporateCustomerFindexPoint(corporateCustomer.getTaxNumber());
	}

	@Override
	public int checkIndividualCustomerFindexPoint(IndividualCustomer individualCustomer) {
		FindexPointService findexPointService= new FindexPointService();
		return findexPointService.individualCustomerFindexPoint(individualCustomer.getIdentityNumber());
	}


		

	
}
