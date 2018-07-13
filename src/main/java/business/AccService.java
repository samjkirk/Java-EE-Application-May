package business;

import javax.inject.Inject;

import repositories.iAccountRepository;

public class AccService implements iAccountsService {
	
	@Inject
	private iAccountRepository repo;

	@Override
	public String findAllAccounts() {
		return repo.findAllAccounts();
	}

	@Override
	public String create(String account) {
		return repo.create(account);
	}

	@Override
	public String update(Long id, String account) {
		return repo.update(id, account);
	}

	@Override
	public String delete(Long id) {
		return repo.delete(id);
	}

}
