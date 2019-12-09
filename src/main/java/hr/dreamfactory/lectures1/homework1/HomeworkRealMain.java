package hr.dreamfactory.lectures1.homework1;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.lectures1.homework1.api.RandomUserAPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomeworkRealMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(hr.dreamfactory.lectures1.homework1.FeignMain.class);

    public static void main(String[] args) {
        if (args.length < 1) {
            LOGGER.error("Please provide a natural number.");
            System.exit(1);
        }
        try {
            int n = Integer.parseInt(args[0]);
            String output = getRandomUser(n);
            //LOGGER.info(output);
            System.out.println(output);
        } catch (NumberFormatException e) {
            LOGGER.error("Input is not a number.", e);
        }
    }

    private static String getRandomUser(int n) {
        RandomUserAPI api = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new GsonDecoder())
                .target(RandomUserAPI.class, "https://randomuser.me/");

        JsonArray result = api.getUsers(Integer.toString(n)).get("results").getAsJsonArray();

        return result.toString();
    }
}
