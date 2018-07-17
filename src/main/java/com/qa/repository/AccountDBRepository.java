package com.qa.repository;

import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;

import com.qa.constants.*;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements iAccountRepository {

	@PersistenceContext(unitName = Constants.UNIT_NAME)
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	@Transactional(REQUIRED)
	public String create(String account) {
		Account result = util.getObjectForJSON(account, Account.class);
		em.persist(result);
		return Constants.ACCOUNT_ADDED;
	}
	
	@Transactional(REQUIRED)
	public String updateAccount(long id, String account) {
		Account update = util.getObjectForJSON(account, Account.class);
		Account original = findAccount(id);
		if (account != null) {
			original = update;
			original.setId(id);
			em.merge(original);
		}
		return Constants.ACCOUNT_UPDATED;
	}
	
	@Transactional(REQUIRED)
	public String delete(long id) {
		Account delete = findAccount(id);
		if (delete != null) {
			em.remove(delete);
		}
		return Constants.ACCOUNT_DELETED;
	}
	
	public String findAllAccounts() {
		return util.getJSONForObject(em.createQuery(Constants.QUERY1).getResultList());
	}
	
	public Account findAccount(long id) {
		return em.find(Account.class, id);
	}
}
