package hr.dreamfactory.lectures1.mario;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.lectures1.mario.api.RecommendationAPI;
import hr.dreamfactory.lectures1.mario.model.BannerResults;
import hr.dreamfactory.lectures1.mario.model.Banner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeignMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeignMain.class);

    public static void main(String[] args) {
        RecommendationAPI api = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new GsonDecoder())
                .target(RecommendationAPI.class, "https://ai.nextuser.com");

        BannerResults result = api.recommend("36b4328c51c32f6ea0a6ca6573e91ffb6e15ce3c");

        for (Banner banner : result.getResults()){
            LOGGER.info("Banner URL: {}", banner.getTitle());
        }


    }

}
