package com.etiya.RentACarSpring.business.concretes;

import java.util.List;

import com.etiya.RentACarSpring.business.abstracts.ApplicationUserService;
import com.etiya.RentACarSpring.business.constants.Messages;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.SuccessDataResult;
import com.etiya.RentACarSpring.dataAccsess.abstracts.ApplicationUserDao;
import com.etiya.RentACarSpring.entities.concretes.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ApplicationUserManager implements ApplicationUserService {

	private ApplicationUserDao applicationUserDao;

	@Autowired
	public ApplicationUserManager(ApplicationUserDao applicationUserDao) {
		super();
		this.applicationUserDao = applicationUserDao;
	}

	@Override
	public DataResult<List<ApplicationUser>> getAll() {
		return new SuccessDataResult<List<ApplicationUser>>(this.applicationUserDao.findAll(), Messages.USERLIST);
	}

}
