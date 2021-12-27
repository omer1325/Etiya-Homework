package com.etiya.RentACarSpring.business.concretes;

import com.etiya.RentACarSpring.business.abstracts.AuthenticationService;
import com.etiya.RentACarSpring.business.constants.Messages;
import com.etiya.RentACarSpring.business.requests.get.CreateLoginRequest;
import com.etiya.RentACarSpring.core.business.BusinessRules;
import com.etiya.RentACarSpring.core.results.ErrorResult;
import com.etiya.RentACarSpring.core.results.Result;
import com.etiya.RentACarSpring.core.results.SuccessResult;
import com.etiya.RentACarSpring.dataAccsess.abstracts.ApplicationUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationManager implements AuthenticationService {

	ApplicationUserDao applicationUserDao;

	@Autowired
	public AuthenticationManager(ApplicationUserDao applicationUserDao) {
		super();
		this.applicationUserDao = applicationUserDao;
	}

	@Override
	public Result logIn(CreateLoginRequest createLoginRequest) {
		var result = BusinessRules.run(checkEmailAndPassword(createLoginRequest));

		if (result != null) {
			return result;
		}

		return new SuccessResult(Messages.LOGINSUCCESS);
	}

	private Result checkEmailAndPassword(CreateLoginRequest createLoginRequest) {
		if (!this.applicationUserDao.existsByEmail(createLoginRequest.getEmail())) {

			return new ErrorResult(Messages.LOGINEMAILERROR);
		}
		if (!this.applicationUserDao.getByEmail(createLoginRequest.getEmail()).getPassword().equals(createLoginRequest.getPassword())) {

			return new ErrorResult (Messages.LOGINPASSWORDERROR);
		}

		return new SuccessResult();
	}
}
