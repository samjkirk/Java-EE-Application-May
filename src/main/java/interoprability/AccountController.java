package interoprability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import business.AccService;
import constants.Constants;
import domain.Account;

@Path(Constants.ACCOUNT_PATH)
public class AccountController {
	
	@Inject
	private AccService service;
	
	@Path(Constants.JSON_PATH)
	@GET
	@Produces({ Constants.PRODUCES })
	public String findAllAccounts() {
		return service.findAllAccounts();
	}
	
	@Path(Constants.JSON_PATH_WITH_ID)
	@GET
	@Produces({ Constants.PRODUCES })
	public Account findAccount(@PathParam(Constants.ID) long id) {
		return service.findAccount(id);
	}
	
	@Path(Constants.JSON_PATH)
	@POST
	@Produces({ Constants.PRODUCES })
	public String create(String account) {
		return service.create(account);
	}
	
	@Path(Constants.JSON_PATH_WITH_ID)
	@PUT
	@Produces({ Constants.PRODUCES })
	public String update(@PathParam(Constants.ID) long id, String account) {
		return service.updateAccount(id, account);
	}
	
	@Path(Constants.JSON_PATH_WITH_ID)
	@DELETE
	@Produces({ Constants.PRODUCES })
	public String delete(@PathParam(Constants.ID) long id) {
		return service.delete(id);
	}
}
