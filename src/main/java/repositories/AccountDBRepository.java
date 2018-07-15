package repositories;

import domain.Account;
import util.JSONUtil;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;

import constants.*;

@Transactional(REQUIRED)
@Default
public class AccountDBRepository implements iAccountRepository {

	@PersistenceContext(unitName = Constants.UNIT_NAME)
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	public String create(String account) {
		Account result = util.getObjectForJSON(account, Account.class);
		em.persist(result);
		return Constants.ACCOUNT_ADDED;
	}
	
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
	
	public String delete(long id) {
		Account delete = findAccount(id);
		if (delete != null) {
			em.remove(delete);
		}
		return Constants.ACCOUNT_DELETED;
	}
	
	@Transactional(SUPPORTS)
	public String findAllAccounts() {
		return util.getJSONForObject(em.createQuery(Constants.QUERY1).getResultList());
	}
	
	@Transactional(SUPPORTS)
	public Account findAccount(long id) {
		return em.find(Account.class, id);
	}
}
