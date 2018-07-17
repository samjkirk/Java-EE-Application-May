package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.*;

import org.apache.log4j.Logger;

import com.qa.constants.Constants;
import com.qa.persistence.business.AccService;
import com.qa.persistence.business.iAccountsChecker;
import com.qa.persistence.domain.Account;

@Path(Constants.ACCOUNT_PATH)
public class AccountController {
	private static final Logger LOGGER = Logger.getLogger(AccountController.class);
	
	@Inject
	private AccService service;
	
	@Path(Constants.JSON_PATH)
	@GET
	@Produces({ Constants.PRODUCES })
	public String findAllAccounts() {
		LOGGER.info("In AccountController findAllAccounts");
		return service.findAllAccounts();
	}
	
	@Path(Constants.JSON_PATH_WITH_ID)
	@GET
	@Produces({ Constants.PRODUCES })
	public Account findAccount(@PathParam(Constants.ID) long id) {
		LOGGER.info("In AccountController findAccount");
		return service.findAccount(id);
	}
	
	@Path(Constants.JSON_PATH)
	@POST
	@Produces({ Constants.PRODUCES })
	public String create(String account) {
		LOGGER.info("In AccountController create");
		return service.create(account);
	}
	
	@Path(Constants.JSON_PATH_WITH_ID)
	@PUT
	@Produces({ Constants.PRODUCES })
	public String update(@PathParam(Constants.ID) long id, String account) {
		LOGGER.info("In AccountController update");
		return service.updateAccount(id, account);
	}
	
	@Path(Constants.JSON_PATH_WITH_ID)
	@DELETE
	@Produces({ Constants.PRODUCES })
	public String delete(@PathParam(Constants.ID) long id) {
		LOGGER.info("In AccountController delete");
		return service.delete(id);
	}
}
