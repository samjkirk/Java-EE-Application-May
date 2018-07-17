package com.qa.persistence.business;

import javax.inject.Inject;
import org.apache.log4j.Logger;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountsChecker implements iAccountsChecker {
	
	private static final Logger LOGGER = Logger.getLogger(iAccountsChecker.class);
	
	@Inject
	private JSONUtil util;
	
	public boolean checkAccountNumber(String account) {
		LOGGER.info("In AccountsChecker checkAccountNumber");
		return util.getObjectForJSON(account, Account.class).getAccountNumber().equals("999999")? false:true;
	}
}
