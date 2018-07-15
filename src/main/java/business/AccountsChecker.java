package business;

import domain.Account;
import javax.inject.Inject;
import util.JSONUtil;

public class AccountsChecker implements iAccountsChecker {
	
	@Inject
	private JSONUtil util;
	
	public boolean checkAccountNumber(String account) {
		return util.getObjectForJSON(account, Account.class).getAccountNumber().equals("999999")? false:true;
	}
}
