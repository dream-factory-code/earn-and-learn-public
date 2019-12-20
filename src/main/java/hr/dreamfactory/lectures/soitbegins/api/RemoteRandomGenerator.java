package hr.dreamfactory.lectures.soitbegins.api;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.lectures.soitbegins.common.UserGenerator;
import hr.dreamfactory.lectures.soitbegins.model.users.User;
import hr.dreamfactory.lectures.soitbegins.utils.ZonedDateTimeAdapter;

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
                .decoder(new GsonDecoder(ZonedDateTimeAdapter.createTimeZoneGson()))
                .target(UserAPI.class, API_ENDPOINT);
    }

    @Override
    public List<User> generate() {
        return api.getUsers(results).getResults();
    }
}
