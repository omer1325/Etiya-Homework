package com.etiya.RentACarSpring.business.concretes;

import com.etiya.RentACarSpring.business.abstracts.PaymentService;
import com.etiya.RentACarSpring.business.constants.Messages;
import com.etiya.RentACarSpring.business.dtos.PaymentDto;
import com.etiya.RentACarSpring.business.requests.payment.CreatePaymentRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import com.etiya.RentACarSpring.core.results.SuccessDataResult;
import com.etiya.RentACarSpring.core.results.SuccessResult;
import com.etiya.RentACarSpring.dataAccsess.abstracts.PaymentDao;
import com.etiya.RentACarSpring.entities.concretes.Payment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentManager implements PaymentService {

	private PaymentDao paymentDao;

	private ModelMapper modelMapper;

	@Autowired
	public PaymentManager(PaymentDao paymentDao, ModelMapper modelMapper) {
		super();
		this.paymentDao = paymentDao;
		this.modelMapper = modelMapper;

	}

	@Override
	public DataResult<PaymentDto> getById(int paymentId) {
		Payment payments = this.paymentDao.getById(paymentId);
		PaymentDto paymentDtos = modelMapper.map(payments, PaymentDto.class);

		return new SuccessDataResult<PaymentDto>(paymentDtos, Messages.CREDITCARDLIST);
	}

	@Override
	public Result add(CreatePaymentRequest createPaymentRequest) {

		Payment payment = new Payment();

		this.paymentDao.save(payment);
		return new SuccessResult();
	}

}
