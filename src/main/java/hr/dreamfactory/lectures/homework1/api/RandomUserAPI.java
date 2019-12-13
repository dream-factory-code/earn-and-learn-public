package hr.dreamfactory.lectures.homework1.api;

import hr.dreamfactory.lectures.homework1.model.UserModels;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/")
@Produces(MediaType.APPLICATION_JSON)
public interface RandomUserAPI {
    @GET
    UserModels fetchUsers(@QueryParam("results") Long result);

    @GET
    UserModels fetchUsers(@QueryParam("results") Long result,
                          @QueryParam("nat") String nationalities);
}