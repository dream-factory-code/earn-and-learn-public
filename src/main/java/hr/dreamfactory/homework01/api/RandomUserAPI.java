package hr.dreamfactory.homework01.api;

import hr.dreamfactory.homework01.model.UsersModels;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/")
@Produces(MediaType.APPLICATION_JSON)
public interface RandomUserAPI {

    @GET
    @Path("?results={result}")
    UsersModels getUsers(@PathParam("result") String result);

}
