package com.qa.repository;

import com.qa.persistence.domain.Account;

public interface iAccountRepository {
	String findAllAccounts();
	String create(String account);
	String updateAccount(long id, String account);
	String delete(long id);
	Account findAccount(long id);
}
