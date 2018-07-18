package com.qa.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AccountMapRepositoryTest {
	private static final String MOCK_DATA_ARRAY = "[{\"id\":0,\"firstName\":\"John\",\"lastName\":\"Doe\",\"accountNumber\":\"123456\"}]";

	private static final String MOCK_OBJECT = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"accountNumber\":\"123456\"}";
	
	private JSONUtil util;
	
	@InjectMocks
	private AccountMapRepository repository;
	
	@Mock
	private Query query;
	
	@Before
	public void setup() {
		repository = new AccountMapRepository();
		util = new JSONUtil();
		repository.setUtil(util);
	}
	
	@Test
	public void testCreateAccount() {
		String reply = repository.create(MOCK_OBJECT);
		Assert.assertEquals(reply, MOCK_OBJECT);
	}
	
	@Test
	public void testUpdateAccount() {
		String reply = repository.updateAccount(1L, MOCK_OBJECT);
		Assert.assertEquals(reply,  MOCK_OBJECT);
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
