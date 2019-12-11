package hr.dreamfactory.lectures.homework1.api;

import hr.dreamfactory.lectures.homework1.model.UsersModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/")
@Produces(MediaType.APPLICATION_JSON)
public interface RandomUserAPI {

    @GET
    UsersModel getResults(@QueryParam("results") int results);
}
