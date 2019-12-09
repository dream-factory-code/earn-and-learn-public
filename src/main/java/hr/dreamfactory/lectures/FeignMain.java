package hr.dreamfactory.lectures;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.lectures.api.RecomendationAPI;
import hr.dreamfactory.lectures.model.Banner;
import hr.dreamfactory.lectures.model.BannerResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FeignMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    ;

    public static void main(String[] args) {
        RecomendationAPI api = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new GsonDecoder())
                .target(RecomendationAPI.class, "https://ai.nextuser.com");
        BannerResults result = api.recommend("36b4328c51c32f6ea0a6ca6573e91ffb6e15ce3c");

        for (Banner banner : result.getResults()) {
            LOGGER.info("banner url {}", banner.getId());
        }
    }
}
