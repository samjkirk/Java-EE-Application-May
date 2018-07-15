package repositories;

import domain.Account;

public interface iAccountRepository {
	String findAllAccounts();
	String create(String account);
	String updateAccount(long id, String account);
	String delete(long id);
	Account findAccount(long id);
}
