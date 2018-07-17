package com.qa.persistence.business;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountsChecker implements iAccountsChecker {
	
	@Inject
	private JSONUtil util;
	
	public boolean checkAccountNumber(String account) {
		return util.getObjectForJSON(account, Account.class).getAccountNumber().equals("999999")? false:true;
	}
}
