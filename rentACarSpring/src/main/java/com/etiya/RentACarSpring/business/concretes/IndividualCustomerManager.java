package com.etiya.RentACarSpring.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.etiya.RentACarSpring.business.abstracts.IndividualCustomerService;
import com.etiya.RentACarSpring.business.constants.Messages;
import com.etiya.RentACarSpring.business.dtos.IndividualCustomerDto;
import com.etiya.RentACarSpring.business.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.RentACarSpring.business.requests.individualCustomer.DeleteIndividualCustomerRequest;
import com.etiya.RentACarSpring.business.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import com.etiya.RentACarSpring.core.results.SuccessDataResult;
import com.etiya.RentACarSpring.core.results.SuccessResult;
import com.etiya.RentACarSpring.dataAccsess.abstracts.IndividualCustomerDao;
import com.etiya.RentACarSpring.entities.concretes.IndividualCustomer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndividualCustomerManager implements IndividualCustomerService {

	@Autowired
	private IndividualCustomerDao individualCustomerDao;
	private ModelMapper modelMapper;

	public IndividualCustomerManager(IndividualCustomerDao individualCustomerDao, ModelMapper modelMapper) {
		super();
		this.individualCustomerDao = individualCustomerDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {

		IndividualCustomer individualCustomer = new IndividualCustomer();

		individualCustomer.setFirstName(createIndividualCustomerRequest.getFirstName());
		individualCustomer.setLastName(createIndividualCustomerRequest.getLastName());
		individualCustomer.setEmail(createIndividualCustomerRequest.getEmail());
		individualCustomer.setPassword(createIndividualCustomerRequest.getPassword());
		individualCustomer.setIdentityNumber(createIndividualCustomerRequest.getIdentityNumber());
		this.individualCustomerDao.save(individualCustomer);
		return new SuccessResult(Messages.CUSTOMERADD);

	}

	@Override
	public Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
		IndividualCustomer individualCustomer = this.individualCustomerDao.getById(updateIndividualCustomerRequest.getId());
			

		individualCustomer.setFirstName(updateIndividualCustomerRequest.getFirstName());
		individualCustomer.setLastName(updateIndividualCustomerRequest.getLastName());
		individualCustomer.setEmail(updateIndividualCustomerRequest.getEmail());
		individualCustomer.setPassword(updateIndividualCustomerRequest.getPassword());
		individualCustomer.setIdentityNumber(updateIndividualCustomerRequest.getIdentityNumber());
		
		this.individualCustomerDao.save(individualCustomer);
		return new SuccessResult(Messages.CUSTOMERUPDATE);
	}

	@Override
	public Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
		IndividualCustomer individualCustomer = this.individualCustomerDao.getById(deleteIndividualCustomerRequest.getId());

		this.individualCustomerDao.delete(individualCustomer);
		return new SuccessResult(Messages.CUSTOMERDELETE);
	}

	@Override
	public DataResult<List<IndividualCustomerDto>> getAll() {
		List<IndividualCustomer> individualCustomers = this.individualCustomerDao.findAll();
		List<IndividualCustomerDto> individualCustomerDtos = individualCustomers.stream()
				.map(individualCustomer -> modelMapper.map(individualCustomer, IndividualCustomerDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<IndividualCustomerDto>>(individualCustomerDtos);
	}
}
