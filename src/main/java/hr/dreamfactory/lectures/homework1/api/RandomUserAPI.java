<<<<<<< HEAD
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
=======
package hr.dreamfactory.lectures.homework1.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/")
@Produces(MediaType.APPLICATION_JSON)
public interface RandomUserAPI {

    @GET
    @Path("?results={results}")
    JsonObject getUsers(@PathParam("results") String results);
}
>>>>>>> f601662168ddc18c54cb97d761597b0e53f12066
