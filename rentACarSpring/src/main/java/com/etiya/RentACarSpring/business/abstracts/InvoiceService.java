package com.etiya.RentACarSpring.business.abstracts;

import com.etiya.RentACarSpring.business.dtos.InvoiceDto;
import com.etiya.RentACarSpring.business.requests.invoice.CreateInvoiceRequest;
import com.etiya.RentACarSpring.business.requests.invoice.DeleteInvoiceRequest;
import com.etiya.RentACarSpring.business.requests.invoice.UpdateInvoiceRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import com.etiya.RentACarSpring.entities.concretes.Invoice;

import java.util.Date;
import java.util.List;



public interface InvoiceService {
	
	Result add(CreateInvoiceRequest createInvoiceRequest);
	
	Result delete(DeleteInvoiceRequest deleteInvoiceRequest);
	
	Result update(UpdateInvoiceRequest updateInvoiceRequest);
	
	
	DataResult<List<InvoiceDto>> getAll();
	DataResult<List<InvoiceDto>> getByCustomer_Id(int customerId);
	DataResult<List<Invoice>> getByInvoicesAllDate(Date startDate, Date endDate);
	
	
	

}
