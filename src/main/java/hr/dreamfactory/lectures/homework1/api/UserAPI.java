package hr.dreamfactory.lectures.homework1.api;

import hr.dreamfactory.lectures.homework1.model.UserResults;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("api/")
@Produces(MediaType.APPLICATION_JSON)
public interface UserAPI {
    @GET
    UserResults getUsers(@QueryParam("results") Integer results);
}

