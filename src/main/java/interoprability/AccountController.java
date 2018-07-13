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

@Path("/account")
public class AccountController {
	
	@Inject
	private AccService service;
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String findAllAccounts() {
		return service.findAllAccounts();
	}
	
	@Path("/json")
	@POST
	@Produces({ "application/json " })
	public String create(String account) {
		return service.create(account);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String update(@PathParam("id") Long id, String account) {
		return service.update(id, account);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String delete(@PathParam("id") Long id) {
		return service.delete(id);
	}
}
