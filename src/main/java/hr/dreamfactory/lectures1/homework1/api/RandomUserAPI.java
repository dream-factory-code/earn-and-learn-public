package hr.dreamfactory.lectures1.homework1.api;

import com.google.gson.JsonObject;
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
    JsonObject getUsers(@PathParam("results") String results);
}

