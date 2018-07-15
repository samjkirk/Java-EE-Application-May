package business;

public interface iAccountsService {
	String findAllAccounts();
	String create(String account);
	String updateAccount(long id, String account);
	String delete(long id);
}
