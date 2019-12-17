package hr.dreamfactory.lectures.homework1.api;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;

public class ApacheUserAPI {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApacheUserAPI.class);

    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private String BASE_URL = "https://randomuser.me/api/";

    public UserAPIResponse getUsers(int numberOfResults) {
        HttpGet request = null;

        try {
            URIBuilder builder = new URIBuilder(BASE_URL).setParameter("results", String.valueOf(numberOfResults));
            request = new HttpGet(builder.build());
        } catch (URISyntaxException e) {
            LOGGER.error("Wrong URL syntax!");
        }

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String result = EntityUtils.toString(entity);
                Gson gson = new Gson();
                UserAPIResponse APIResponse = gson.fromJson(result, UserAPIResponse.class);
                return APIResponse;
            }
        } catch (IOException e) {
            LOGGER.error("Error occurred during reading input stream!");
        }

        LOGGER.warn("JSON returned from API cannot be parsed to UserAPIResponse object.");
        return null;
    }
}
