package com.etiya.RentACarSpring.dataAccsess.abstracts;

import java.util.Date;
import java.util.List;

import com.etiya.RentACarSpring.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDao extends JpaRepository<Invoice, Integer> {

	List<Invoice> getByCustomer_UserId(int customerId);

	List<Invoice> getAllByInvoiceDateLessThanEqualAndInvoiceDateGreaterThanEqual(Date startDate, Date endDate);

}
