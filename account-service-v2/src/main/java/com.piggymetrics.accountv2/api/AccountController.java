package com.piggymetrics.accountv2.api;

/*import com.piggymetrics.accountv2.domain.model.Account;
import com.piggymetrics.accountv2.domain.model.User;
import com.piggymetrics.accountv2.domain.service.AccountService;*/

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Principal;

@Path("/accounts/v2")
public class AccountController {

    @GET
    @Produces("text/plain")
    public Response getCurrentAccount() {
        return Response.ok("account-v2!").build();
    }

    /*@Inject
    private AccountService accountService;

    @Path("/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccountByName(@PathParam("name") String name) {
        return accountService.findByName(name);
    }

    @Path("/current")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Account getCurrentAccount(Principal principal) {
        return accountService.findByName(principal.getName());
    }

    @Path("/current")
    @PUT
    public void saveCurrentAccount(Principal principal, @Valid Account account) {
        accountService.saveChanges(principal.getName(), account);
    }

    @POST
    public Account createNewAccount(@Valid User user) {
        return accountService.create(user);
    }*/
}
