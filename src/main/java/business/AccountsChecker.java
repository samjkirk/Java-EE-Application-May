package business;

import domain.Account;
import util.JSONUtil;

public class AccountsChecker implements iAccountsChecker {
	
	private JSONUtil util;

	public boolean checkFirstName(String account) {
		return util.getObjectForJSON(account, Account.class).getFirstName().equals("99999")? true:false;
	}
	
	public boolean checkLastName(String account) {
		return util.getObjectForJSON(account, Account.class).getLastName().equals("99999")? true:false;
	}
	
	public boolean checkAccountNumber(String account) {
		return util.getObjectForJSON(account, Account.class).getAccountNumber() == 99999? true:false;
	}
}
