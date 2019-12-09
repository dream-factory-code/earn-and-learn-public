package hr.dreamfactory.lectures.api;

import hr.dreamfactory.lectures.model.BannerResults;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/r/a/")
@Produces(MediaType.APPLICATION_JSON)

public interface RecomendationAPI {

    @GET
    @Path("{id}")
    BannerResults recommend(@PathParam("id") String recomendationId);
}
