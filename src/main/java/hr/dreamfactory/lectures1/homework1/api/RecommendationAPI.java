package hr.dreamfactory.lectures1.homework1.api;

import hr.dreamfactory.lectures1.homework1.model.BannerResults;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/r/a/")
@Produces(MediaType.APPLICATION_JSON)
public interface RecommendationAPI {

    @GET
    @Path("{id}")
    BannerResults recommend(@PathParam("id") String recommendationId);
}
