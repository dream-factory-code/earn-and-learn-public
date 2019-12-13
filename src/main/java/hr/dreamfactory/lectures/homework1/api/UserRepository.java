package hr.dreamfactory.lectures.homework1.api;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.lectures.homework1.model.common.User;
import hr.dreamfactory.lectures.homework1.model.common.Users;

import java.util.List;

public class UserRepository implements Users {
    private final Long size;
    private final String nationality;

    private final RandomUserAPI api;

    public UserRepository(String baseUrl, Long size, String nationality) {
        this.size = size;
        api = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new GsonDecoder())
                .target(RandomUserAPI.class, baseUrl);

        this.nationality = nationality;
    }

    public UserRepository(String baseUrl, Long size) {
        this(baseUrl, size, null);
    }

    @Override
    public List<? extends User> getRandomUsers() {
        if (nationality == null) {
            return api.fetchUsers(size).getResults();
        }

        return api.fetchUsers(size, nationality).getResults();
    }
}