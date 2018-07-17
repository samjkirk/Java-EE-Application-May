package com.qa.persistence.business;

import javax.inject.Inject;
import org.apache.log4j.Logger;
import com.qa.constants.Constants;
import com.qa.persistence.domain.Account;
import com.qa.repository.iAccountRepository;

public class AccService implements iAccountsService {
	
	private static final Logger LOGGER = Logger.getLogger(iAccountsService.class);
	
	@Inject
	private iAccountRepository repo;
	
	@Inject
	private iAccountsChecker accountChecker;

	public String findAllAccounts() {
		LOGGER.info("In AccService findAllAccounts");
		return repo.findAllAccounts();
	}

	public String create(String account) {
		if(!accountChecker.checkAccountNumber(account)) {
			LOGGER.info("In AccService create 'banned account message'");
			return Constants.BANNED_ACCOUNT_MESSAGE;
		} else {
			LOGGER.info("In AccService create");
			return repo.create(account);
		}
	}

	public String updateAccount(long id, String account) {
		if(!accountChecker.checkAccountNumber(account)) {
			LOGGER.info("In AccService updateAccount 'banned account message'");
			return Constants.BANNED_ACCOUNT_MESSAGE;
		} else {
			LOGGER.info("In AccService updateAccount");
			return repo.updateAccount(id, account);
		}
		
	}

	public String delete(long id) {
		LOGGER.info("In AccService delete");
		return repo.delete(id);
	}

	public Account findAccount(long id) {
		LOGGER.info("In AccService findAccount");
		return repo.findAccount(id);
	}

}
