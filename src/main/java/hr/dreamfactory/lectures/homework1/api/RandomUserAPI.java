package hr.dreamfactory.lectures.homework1.api;

import hr.dreamfactory.lectures.homework1.common.Users;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/")
@Produces(MediaType.APPLICATION_JSON)
public interface RandomUserAPI {

    @GET
    @Path("{results}")
    Users getUsers(@PathParam("results")int results);
}
