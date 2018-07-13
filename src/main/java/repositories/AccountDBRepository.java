package repositories;

import domain.Account;
import util.JSONUtil;

import java.util.Collection;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.persistence.Query;

import constants.*;

@Default
@Transactional(TxType.SUPPORTS)
public class AccountDBRepository implements iAccountRepository {

	@PersistenceContext(unitName = Constants.UNIT_NAME)
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String findAllAccounts() {
		Query getAccountsQuery = em.createQuery(Constants.QUERY1);
		@SuppressWarnings("unchecked")
		Collection<Account> accountsList = (Collection<Account>) getAccountsQuery.getResultList();
		return util.getJSONForObject(accountsList);
	}
	
	public Account findAccount(Long id) {
		return em.find(Account.class, id);
	}
	
	@Override
	@Transactional(TxType.REQUIRED)
	public String create(String account) {
		Account result = util.getObjectForJSON(account, Account.class);
		em.persist(result);
		return Constants.ACCOUNT_ADDED;
	}
	
	@Override
	@Transactional(TxType.REQUIRED)
	public String update(Long id, String account) {
		Account update = util.getObjectForJSON(account, Account.class);
		Account original = findAccount(id);
		if (account != null) {
			original = update;
			em.merge(original);
		}
		return Constants.ACCOUNT_UPDATED;
	}
	
	@Override
	@Transactional(TxType.REQUIRED)
	public String delete(Long id) {
		Account delete = findAccount(id);
		if (delete != null) {
			em.remove(delete);
		}
		return Constants.ACCOUNT_DELETED;
	}
}
