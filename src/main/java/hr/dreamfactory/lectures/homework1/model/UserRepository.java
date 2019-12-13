package hr.dreamfactory.lectures.homework1.model;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.lectures.homework1.api.RandomUserAPI;
import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.common.Users;

import java.util.List;

public class UserRepository implements Users {
    private final int results;
    private RandomUserAPI api;

    public UserRepository(int results) {
        this.results = results;
        this.api = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new GsonDecoder())
                .target(RandomUserAPI.class, "https://randomuser.me");

    }

    public UserRepository() {
        this(10);
    }

    @Override
    public List<? extends User> getRandomUsers() {
        return api.getResults(results)
                .getResults();

    }
}
