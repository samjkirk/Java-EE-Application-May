package business;

public interface iAccountsService {
	String findAllAccounts();
	String create(String account);
	String update(Long id, String account);
	String delete(Long id);
}
