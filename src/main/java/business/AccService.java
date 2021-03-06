package business;

import javax.inject.Inject;

import constants.Constants;
import domain.Account;
import repositories.iAccountRepository;

public class AccService implements iAccountsService {
	
	@Inject
	private iAccountRepository repo;
	
	@Inject
	private iAccountsChecker accountChecker;

	public String findAllAccounts() {
		return repo.findAllAccounts();
	}

	public String create(String account) {
		if(!accountChecker.checkAccountNumber(account)) {
			return Constants.BANNED_ACCOUNT_MESSAGE;
		} else {
			return repo.create(account);
		}
	}

	public String updateAccount(long id, String account) {
		if(!accountChecker.checkAccountNumber(account)) {
			return Constants.BANNED_ACCOUNT_MESSAGE;
		}
		else {
			return repo.updateAccount(id, account);
		}
		
	}

	public String delete(long id) {
		return repo.delete(id);
	}

	public Account findAccount(long id) {
		return repo.findAccount(id);
	}

}
