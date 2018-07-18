package com.qa.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Transaction;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AccountDBRepositoryTest {
	
	private static final String MOCK_DATA_ARRAY = "[{\"id\":0,\"firstName\":\"John\",\"lastName\":\"Doe\",\"accountNumber\":\"123456\",\"transactions\":[]}]";

	private static final String MOCK_OBJECT = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"accountNumber\":\"123456\"}";
	
	private JSONUtil util;
	
	@InjectMocks
	private AccountDBRepository repository;
	
	@Mock
	private EntityManager manager;
	
	@Mock
	private Query query;
	
	@Before
	public void setup() {
		repository.setManager(manager);
		util = new JSONUtil();
		repository.setUtil(util);
	}
	
	@Test
	public void testFindAllAccounts() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Account> accounts = new ArrayList<Account>();
		List<Transaction> transactions = new ArrayList<Transaction>();
		accounts.add(new Account("John", "Doe", "123456", transactions));
		Mockito.when(query.getResultList()).thenReturn(accounts);
		Assert.assertEquals(MOCK_DATA_ARRAY, repository.findAllAccounts());
	}
	
	@Test
	public void testCreateAccount() {
		String reply = repository.create(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"account has been added\"}");
	}
	
	@Test
	public void testUpdateAccount() {
		String reply = repository.updateAccount(1L, MOCK_OBJECT);
		Assert.assertEquals(reply,  "{\"message\": \"account updated\"}");
	}
	
	@Test
	public void testFindAccount() {
		Account reply = repository.findAccount(1L);
		Assert.assertEquals(reply, repository.findAccount(1L));
	}
	
	@Test
	public void testDeleteAccount() {
		String reply = repository.delete(1L);
		Assert.assertEquals(reply, "{\"message\": \"account deleted\"}");
	}
	
}
