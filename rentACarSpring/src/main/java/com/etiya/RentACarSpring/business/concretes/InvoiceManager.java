package com.etiya.RentACarSpring.business.concretes;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.etiya.RentACarSpring.business.abstracts.AdditionalServiceService;
import com.etiya.RentACarSpring.business.abstracts.InvoiceService;
import com.etiya.RentACarSpring.business.constants.Messages;
import com.etiya.RentACarSpring.business.dtos.InvoiceDto;
import com.etiya.RentACarSpring.business.requests.invoice.CreateInvoiceRequest;
import com.etiya.RentACarSpring.business.requests.invoice.DeleteInvoiceRequest;
import com.etiya.RentACarSpring.business.requests.invoice.UpdateInvoiceRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import com.etiya.RentACarSpring.core.results.SuccessDataResult;
import com.etiya.RentACarSpring.core.results.SuccessResult;
import com.etiya.RentACarSpring.dataAccsess.abstracts.CustomerDao;
import com.etiya.RentACarSpring.dataAccsess.abstracts.InvoiceDao;
import com.etiya.RentACarSpring.dataAccsess.abstracts.RentalDao;
import com.etiya.RentACarSpring.entities.abstracts.Customer;
import com.etiya.RentACarSpring.entities.concretes.Invoice;
import com.etiya.RentACarSpring.entities.concretes.Rental;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvoiceManager implements InvoiceService {

	private RentalDao rentalDao;
	private CustomerDao customerDao;
	private InvoiceDao invoiceDao;

	private AdditionalServiceService additionalServiceService;
	private ModelMapper modelMapper;

	@Autowired
	public InvoiceManager(RentalDao rentalDao, CustomerDao customerDao, InvoiceDao invoiceDao, ModelMapper modelMapper,
			 AdditionalServiceService additionalServiceService) {
		super();
		this.rentalDao = rentalDao;
		this.customerDao = customerDao;
		this.invoiceDao = invoiceDao;
		this.modelMapper = modelMapper;
		this.additionalServiceService = additionalServiceService;

	}

	@Override
	public Result add(CreateInvoiceRequest createInvoiceRequest) {

		Customer customer = this.customerDao.getById(createInvoiceRequest.getCustomerId());


		Rental rental = this.rentalDao.getById(createInvoiceRequest.getRentalId());
	

		Invoice invoice = new Invoice();
		invoice.setInvoiceAmount
		(this.rentalDao.getById(createInvoiceRequest.getRentalId()).getAmount());
		
		invoice.setInvoiceDate(createInvoiceRequest.getInvoiceDate());
		invoice.setInvoiceNumber(createInvoiceRequest.getInvoiceNumber());
		invoice.setRentDate(this.rentalDao.getById(createInvoiceRequest.getRentalId()).getRentDate());
		invoice.setReturnDate(this.rentalDao.getById(createInvoiceRequest.getRentalId()).getReturnDate());

		invoice.setTotalRentDay(ChronoUnit.DAYS.between(
				this.rentalDao.getById(createInvoiceRequest.getRentalId()).getRentDate().toInstant(),
				this.rentalDao.getById(createInvoiceRequest.getRentalId()).getReturnDate().toInstant()));

		invoice.setCustomer(customer);
		invoice.setRental(rental);

		this.invoiceDao.save(invoice);
		return new SuccessResult(Messages.INVOICEADD);

	}

	@Override
	public Result delete(DeleteInvoiceRequest deleteInvoiceRequest) {
		Invoice invoice = this.invoiceDao.getById(deleteInvoiceRequest.getInvoiceId());

		this.invoiceDao.delete(invoice);
		return new SuccessResult(Messages.INVOICEDELETE);
	}

	@Override
	public Result update(UpdateInvoiceRequest updateInvoiceRequest) {

		long rentDays = ChronoUnit.DAYS.between(
				this.rentalDao.getById(updateInvoiceRequest.getRentalId()).getRentDate().toInstant(),
				this.rentalDao.getById(updateInvoiceRequest.getRentalId()).getReturnDate().toInstant());
		Customer customer = new Customer();
		customer.setUserId(updateInvoiceRequest.getCustomerId());

		Rental rental = new Rental();
		rental.setRentalId(updateInvoiceRequest.getRentalId());

		Invoice invoice = new Invoice();
		invoice.setInvoiceAmount(
				rentDays * this.rentalDao.getById(updateInvoiceRequest.getRentalId()).getCar().getDailyPrice());
		invoice.setInvoiceDate(updateInvoiceRequest.getInvoiceDate());
		invoice.setInvoiceNumber(updateInvoiceRequest.getInvoiceNumber());
		invoice.setInvoiceId(updateInvoiceRequest.getInvoiceId());

		invoice.setTotalRentDay(ChronoUnit.DAYS.between(
				this.rentalDao.getById(updateInvoiceRequest.getRentalId()).getRentDate().toInstant(),
				this.rentalDao.getById(updateInvoiceRequest.getRentalId()).getReturnDate().toInstant()));

		invoice.setCustomer(customer);
		invoice.setRental(rental);

		this.invoiceDao.save(invoice);
		return new SuccessResult(Messages.INVOICEADD);

	}

	@Override
	public DataResult<List<InvoiceDto>> getAll() {

		List<Invoice> invoices = this.invoiceDao.findAll();

		List<InvoiceDto> invoiceDetailDtos = new ArrayList<InvoiceDto>();

		for (Invoice invoic : invoices) {

			InvoiceDto invoiceDto = modelMapper.map(invoic, InvoiceDto.class);
			invoiceDto.setAdditionalServiceDetailDtos(
					this.additionalServiceService.getByRentalId(invoic.getRental().getRentalId()).getData());

			invoiceDetailDtos.add(invoiceDto);

		}

		return new SuccessDataResult<List<InvoiceDto>>(invoiceDetailDtos, Messages.INVOICELIST);
	}

	@Override
	public DataResult<List<InvoiceDto>> getByCustomer_Id(int customerId) {
		
		List<Invoice> invoices = this.invoiceDao.getByCustomer_UserId(customerId);
		List<InvoiceDto> invoiceDtos = invoices.stream()
				.map(invoice -> modelMapper.map(invoice, InvoiceDto.class)).collect(Collectors.toList());

		return new SuccessDataResult<List<InvoiceDto>>(invoiceDtos, Messages.CREDITCARDLIST);
	}

	@Override
	public DataResult<List<Invoice>> getByInvoicesAllDate(Date startDate, Date endDate) {
		return new SuccessDataResult<List<Invoice>>(
				this.invoiceDao.getAllByInvoiceDateLessThanEqualAndInvoiceDateGreaterThanEqual(startDate, endDate),
				Messages.INVOICELIST);
	}

}