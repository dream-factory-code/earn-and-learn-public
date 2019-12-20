package hr.dreamfactory.lectures.soitbegins.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("api/")
@Produces(MediaType.APPLICATION_JSON)
public interface UserAPI {
    @GET
    UserAPIResponse getUsers(@QueryParam("results") Integer results);
}

