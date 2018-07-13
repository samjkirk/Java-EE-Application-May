package repositories;


public interface iAccountRepository {
	String findAllAccounts();
	String create(String account);
	String update(Long id, String account);
	String delete(Long id);
}
