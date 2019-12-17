package hr.dreamfactory.lectures.homework1.api;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.lectures.homework1.api.UserAPI;
import hr.dreamfactory.lectures.homework1.common.UserGenerator;
import hr.dreamfactory.lectures.homework1.model.User;

import java.util.List;

public class RemoteRandomGenerator implements UserGenerator {
    public final int results;
    public static final String API_ENDPOINT = "https://randomuser.me/";

    private final UserAPI api;

    public RemoteRandomGenerator() {
        this(10);
    }

    public RemoteRandomGenerator(int results) {
        this.results = results;
        api = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new GsonDecoder())
                .target(UserAPI.class, API_ENDPOINT);
    }

    @Override
    public List<User> generate() {
        return api.getUsers(results).getResults();
    }
}
