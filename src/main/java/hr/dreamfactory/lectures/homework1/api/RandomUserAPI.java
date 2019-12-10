package hr.dreamfactory.lectures.homework1.api;

import hr.dreamfactory.lectures.homework1.model.UsersModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/")
@Produces(MediaType.APPLICATION_JSON)
public interface RandomUserAPI {

    @GET
    @Path("?results={results}")
    UsersModel getResults(@PathParam("results") String results);
}
