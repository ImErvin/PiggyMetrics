package api;

import domain.Account;
import domain.User;
import service.AccountService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.security.Principal;

@Path("/account")
public class AccountController {

    @Inject
    private AccountService accountService;

    @Path("/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAccountByName(@PathParam("name") String name) {
        System.out.println("Name from input " + name);
        return accountService.findByName(name);
    }

    @Path("/current")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCurrentAccount() {
        return "Hello from current";
    }

    @Path("/current")
    @PUT
    public void saveCurrentAccount(Principal principal, @Valid Account account) {
        accountService.saveChanges(principal.getName(), account);
    }

    @POST
    public Account createNewAccount(@Valid User user) {
        return accountService.create(user);
    }
}
