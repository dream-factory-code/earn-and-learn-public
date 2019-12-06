package hr.dreamfactory.lectures.vice.api;

import hr.dreamfactory.lectures.vice.model.BannerResults;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/r/a/")
@Produces(MediaType.APPLICATION_JSON)
public interface RecommendationAPI {

    @GET
    @Path("{id}")
    BannerResults recommend(@PathParam("id") String recommendationId);
}
