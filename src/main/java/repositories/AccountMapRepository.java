package repositories;

import java.util.*;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import constants.Constants;
import domain.Account;
import util.JSONUtil;

@ApplicationScoped
@Alternative
public class AccountMapRepository implements iAccountRepository {
	
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
		return util.getJSONForObject(accountsList.values());
	}
	
	@Override
	public Account findAccount(long id) {
		return accountsList.get(id);
	}

	@Override
	public String create(String account) {
		ID++;
		Account create = util.getObjectForJSON(account, Account.class);
		create.setId(ID);
		accountsList.put(ID, create);
		return account;
	}

	@Override
	public String updateAccount(long id, String account) {
		Account update = util.getObjectForJSON(account, Account.class);
		update.setId(id);
		accountsList.put(id , update);
		return account;
	}

	@Override
	public String delete(long id) {
		accountsList.remove(id);
		return Constants.ACCOUNT_DELETED;
	}
}
