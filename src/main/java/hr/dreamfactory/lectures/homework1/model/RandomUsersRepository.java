package hr.dreamfactory.lectures.homework1.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.lectures.homework1.api.ApacheUserAPI;
import hr.dreamfactory.lectures.homework1.api.UserAPI;
import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.common.Users;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class RandomUsersRepository implements Users {
    public final int results;
    public static final String API_ENDPOINT = "https://randomuser.me/api/?results=10";

    private final ApacheUserAPI api;

    public RandomUsersRepository() {
        this(10);
    }

    public RandomUsersRepository(int results) {
        this.results = results;
        api = new ApacheUserAPI();
    }

    @Override
    public List<? extends User> getRandomUsers() {
        return api.getUsers(results).getResults();
    }


}
