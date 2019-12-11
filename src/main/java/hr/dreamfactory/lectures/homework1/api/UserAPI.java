package hr.dreamfactory.lectures.homework1.api;

import hr.dreamfactory.lectures.homework1.model.UserResults;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("api/")
@Produces(MediaType.APPLICATION_JSON)
public interface UserAPI {
    @GET
    UserResults getUsers(@QueryParam("results") Integer results);
}

