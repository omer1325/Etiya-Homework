package com.etiya.RentACarSpring.ws;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.etiya.RentACarSpring.business.abstracts.InvoiceService;
import com.etiya.RentACarSpring.business.dtos.InvoiceDto;
import com.etiya.RentACarSpring.business.requests.invoice.CreateInvoiceRequest;
import com.etiya.RentACarSpring.business.requests.invoice.DeleteInvoiceRequest;
import com.etiya.RentACarSpring.business.requests.invoice.UpdateInvoiceRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import com.etiya.RentACarSpring.entities.concretes.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/invoices")
public class InvoicesController {
	
	InvoiceService invoiceService;
	
	@Autowired
	public InvoicesController(InvoiceService invoiceService) {
		super();
		this.invoiceService = invoiceService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<InvoiceDto>> getAll() {
		return this.invoiceService.getAll();
	}
	
	@GetMapping("/getbycustomerıd")
	public DataResult<List<InvoiceDto>> getByCustomer_Id(int customerId) {
		return this.invoiceService.getByCustomer_Id(customerId);
	}
	
	
	@GetMapping("/findinvoicesbetweentwodate")
	public DataResult<List<Invoice>> findInvoicesBetweenTwoDate(@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")
	Date endDate, @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate) {
		
	System.out.println(endDate.toString()+startDate.toString());
		return this.invoiceService.getByInvoicesAllDate(endDate,startDate);
	}
	
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateInvoiceRequest createInvoiceRequest) {
		return this.invoiceService.add(createInvoiceRequest);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody UpdateInvoiceRequest updateInvoiceRequest) {
		return this.invoiceService.update(updateInvoiceRequest);
	}

	@PutMapping("/delete")
	public Result delete(DeleteInvoiceRequest deleteInvoiceRequest) {
		return this.invoiceService.delete(deleteInvoiceRequest);
	}
	
	
	
	
	

}
