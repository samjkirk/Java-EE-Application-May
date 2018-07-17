package com.qa.persistence.business;

import com.qa.persistence.domain.Account;

public interface iAccountsService {
	String findAllAccounts();
	String create(String account);
	String updateAccount(long id, String account);
	String delete(long id);
	Account findAccount(long id);
}
