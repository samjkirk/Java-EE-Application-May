package repositories;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import constants.Constants;
import domain.Account;
import util.*;

@Alternative
public class AccountMapRepository implements iAccountRepository {
	
	private Long ID;
	private Map<Long, Account> accountsList;
	
	@Inject
	private JSONUtil util;
	
	public AccountMapRepository() {
		this.accountsList = new HashMap<Long, Account>();
		ID = 1L;
	}
 
	@Override
	public String findAllAccounts() {
		return util.getJSONForObject(accountsList.values());
	}
	
	public Account findAccount(Long id) {
		return accountsList.get(id);
	}

	@Override
	public String create(String account) {
		ID++;
		Account create = util.getObjectForJSON(account, Account.class);
		accountsList.put(ID, create);
		return account;
	}

	@Override
	public String update(Long id, String account) {
		Account update = util.getObjectForJSON(account, Account.class);
		accountsList.put(id , update);
		return account;
	}

	@Override
	public String delete(Long id) {
		accountsList.remove(id);
		return Constants.ACCOUNT_DELETED;
	}
}
