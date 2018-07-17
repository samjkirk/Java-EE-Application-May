package com.qa.repository;

import java.util.*;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.constants.Constants;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative
public class AccountMapRepository implements iAccountRepository {
	
	private static final Logger LOGGER = Logger.getLogger(iAccountRepository.class);
	
	private long ID;
	private Map<Long, Account> accountsList;
	
	@Inject
	private JSONUtil util;
	
	public AccountMapRepository() {
		this.accountsList = new HashMap<Long, Account>();
		ID = 0L;
	}
 
	@Override
	public String findAllAccounts() {
		LOGGER.info("In AccountDBRepository findAllAccounts");
		return util.getJSONForObject(accountsList.values());
	}
	
	@Override
	public Account findAccount(long id) {
		LOGGER.info("In AccountDBRepository findAccount");
		return accountsList.get(id);
	}

	@Override
	public String create(String account) {
		LOGGER.info("In AccountDBRepository create");
		ID++;
		Account create = util.getObjectForJSON(account, Account.class);
		create.setId(ID);
		accountsList.put(ID, create);
		return account;
	}

	@Override
	public String updateAccount(long id, String account) {
		LOGGER.info("In AccountDBRepository updateAccount");
		Account update = util.getObjectForJSON(account, Account.class);
		update.setId(id);
		accountsList.put(id , update);
		return account;
	}

	@Override
	public String delete(long id) {
		LOGGER.info("In AccountDBRepository delete");
		accountsList.remove(id);
		return Constants.ACCOUNT_DELETED;
	}
}
