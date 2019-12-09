package hr.dreamfactory.lectures.homework1.api;

import com.google.gson.JsonObject;
import hr.dreamfactory.lectures.homework1.model.UsersModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api/")
@Produces(MediaType.APPLICATION_JSON)
public interface UserAPI {
    @GET
    @Path("?results={results}")
    UsersModel getUsers(@PathParam("results") String results);
}

