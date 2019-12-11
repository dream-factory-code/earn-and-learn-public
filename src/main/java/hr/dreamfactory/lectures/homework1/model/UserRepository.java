package hr.dreamfactory.lectures.homework1.model;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.lectures.homework1.api.UserAPI;
import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.common.Users;

import java.util.List;

public class UserRepository implements Users {
    public static final int RESULTS = 10;
    public static final String API_ENDPOINT = "https://randomuser.me/";

    private final UserAPI api;

    public UserRepository() {
        api = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new GsonDecoder())
                .target(UserAPI.class, API_ENDPOINT);
    }

    @Override
    public List<? extends User> getRandomUsers() {
        return api.getUsers(RESULTS).getResults();
    }
}
