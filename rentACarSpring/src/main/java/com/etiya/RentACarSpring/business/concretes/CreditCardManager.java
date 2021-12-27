package com.etiya.RentACarSpring.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.etiya.RentACarSpring.business.abstracts.CreditCardService;
import com.etiya.RentACarSpring.business.constants.Messages;
import com.etiya.RentACarSpring.business.dtos.CreditCardDto;
import com.etiya.RentACarSpring.business.requests.creditCard.CreateCreditCardRequest;
import com.etiya.RentACarSpring.business.requests.creditCard.DeleteCreditCardRequest;
import com.etiya.RentACarSpring.business.requests.creditCard.UpdateCreditCardRequest;
import com.etiya.RentACarSpring.core.business.BusinessRules;
import com.etiya.RentACarSpring.core.results.*;
import com.etiya.RentACarSpring.dataAccsess.abstracts.CreditCardDao;
import com.etiya.RentACarSpring.entities.abstracts.Customer;
import com.etiya.RentACarSpring.entities.concretes.CreditCard;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardManager implements CreditCardService {

	private CreditCardDao creditCardDao;
	private ModelMapper modelMapper;

	@Autowired
	public CreditCardManager(CreditCardDao creditCardDao, ModelMapper modelMapper) {
		super();
		this.creditCardDao = creditCardDao;
		this.modelMapper = modelMapper;

	}

	@Override
	public DataResult<List<CreditCardDto>> getAll() {

		List<CreditCard> creditCards = this.creditCardDao.findAll();
		List<CreditCardDto> creditCardDtos = creditCards.stream()
				.map(creditCard -> modelMapper.map(creditCard, CreditCardDto.class)).collect(Collectors.toList());

		return new SuccessDataResult<List<CreditCardDto>>(creditCardDtos, Messages.CREDITCARDLIST);

	}

	@Override
	public DataResult<List<CreditCardDto>> getCreditCardByCustomerId(int userId) {

		List<CreditCard> creditCards = this.creditCardDao.getCreditCardByCustomer_UserId(userId);
		List<CreditCardDto> creditCardDtos = creditCards.stream()
				.map(creditCard -> modelMapper.map(creditCard, CreditCardDto.class)).collect(Collectors.toList());

		return new SuccessDataResult<List<CreditCardDto>>(creditCardDtos, Messages.CREDITCARDLIST);

	}

	public Result add(CreateCreditCardRequest createCreditCardRequest) {

		var result = BusinessRules.run(checkCardControllers(createCreditCardRequest.getCardNumber()),
				checkCardPullDate(createCreditCardRequest.getPullDate()),
				checkCardCvc(createCreditCardRequest.getCvc()));

		if (result != null) {
			return result;
		}

		Customer customer = new Customer();
		customer.setUserId(createCreditCardRequest.getCustomerId());

		CreditCard creditCard = new CreditCard();
		creditCard.setCardNumber(createCreditCardRequest.getCardNumber());
		creditCard.setCardName(createCreditCardRequest.getCardName());
		creditCard.setCvc(createCreditCardRequest.getCvc());
		creditCard.setPullDate(createCreditCardRequest.getPullDate());

		creditCard.setCustomer(customer);

		this.creditCardDao.save(creditCard);
		return new SuccessResult(Messages.CREDITCARDADD);

	}

	@Override
	public Result delete(DeleteCreditCardRequest deleteCreditCardRequest) {
		CreditCard creditCard = new CreditCard();
		creditCard.setCardId(deleteCreditCardRequest.getCardId());

		this.creditCardDao.delete(creditCard);
		return new SuccessResult(Messages.CREDITCARDELETE);
	}

	@Override
	public Result update(UpdateCreditCardRequest updateCreditCardRequest) {

		Customer customer = new Customer();
		customer.setUserId(updateCreditCardRequest.getCustomerId());

		CreditCard creditCard = this.creditCardDao.getById(updateCreditCardRequest.getCardId());
		creditCard.setCardNumber(updateCreditCardRequest.getCardNumber());
		creditCard.setCardName(updateCreditCardRequest.getCardName());
		creditCard.setCvc(updateCreditCardRequest.getCvc());
		creditCard.setPullDate(updateCreditCardRequest.getPullDate());

		creditCard.setCustomer(customer);

		this.creditCardDao.save(creditCard);
		return new SuccessResult(Messages.CREDITCARDUPDATE);

	}

	public Result checkCardControllers(String cardNumber) {

		String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" + "(?<mastercard>5[1-5][0-9]{14})|"
				+ "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" + "(?<amex>3[47][0-9]{13})|"
				+ "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" + "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cardNumber);

		if (!matcher.matches()) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

	public Result checkCardCvc(String cardCvc) {
		String regex = "^[0-9]{3,4}$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cardCvc);

		if (!matcher.matches()) {
			return new ErrorResult();
		}
		return new SuccessResult();

	}

	public Result checkCardPullDate(String pullDate) {
		String regex = "^(0[1-9]|1[0-2])/?(([0-9]{4}|[0-9]{2})$)";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pullDate);

		if (!matcher.matches()) {
			return new ErrorResult();
		}
		return new SuccessResult();

	}
}
