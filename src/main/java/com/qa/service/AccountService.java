package com.qa.service;

import com.qa.domain.Account;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Transactional(TxType.SUPPORTS)
public class AccountService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public List<Account> findAllAccounts() {
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a ORDER BY a.id DESC", Account.class);
		return query.getResultList();
	}
	
	public Account findAccount(Long id) {
		return em.find(Account.class, id);
	}
	
	@Transactional(TxType.REQUIRED)
	public Account create(Account account) {
		em.persist(account);
		return account;
	}
	
	@Transactional(TxType.REQUIRED)
	public Account update(Account account, String firstName, String lastName, int accountNumber) {
		account.setFirstName(firstName);
		account.setLastName(lastName);
		account.setAccountNumber(accountNumber);
		em.refresh(account);
		return account;
	}
	
	@Transactional(TxType.REQUIRED)
	public void delete(Account account) {
		em.remove(account);
	}
}
