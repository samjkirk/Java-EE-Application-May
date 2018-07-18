package com.qa.interoperability;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.business.AccService;
import com.qa.persistence.domain.Account;


@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {
	
	private static final String MOCK_VALUE = "test_value";
	
	private static final String MOCK_VALUE2 = "test_value_2";
	
	@InjectMocks
	private AccountController endpoint;
	
	@Mock
	private AccService service;
	
	
	@Before
	public void setUp() {
		endpoint.setService(service);
	}
	
	@Test
	public void testFindAllAccounts() {
		Mockito.when(service.findAllAccounts()).thenReturn(MOCK_VALUE); 
		Assert.assertEquals(MOCK_VALUE, endpoint.findAllAccounts());
	}
	
	@Test
	public void testCreateAccount() {
		Mockito.when(service.create(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.create(MOCK_VALUE2));
		Mockito.verify(service).create(MOCK_VALUE2);
	}
	
	@Test
	public void testUpdateAccount() {
		Mockito.when(service.updateAccount(1L, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.update(1L, MOCK_VALUE2));
		Mockito.verify(service).updateAccount(1L, MOCK_VALUE2);
	}
	
	@Test
	public void testFindAccount() {
		Account reply = service.findAccount(1L);
		Assert.assertEquals(reply, service.findAccount(1L));
	}
	
	@Test
	public void testDeleteAccount() {
		Mockito.when(service.delete(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.delete(1L));
		Mockito.verify(service).delete(1L);
	}
}
