package hr.dreamfactory.lectures.homework1.api;

import com.google.gson.Gson;
import hr.dreamfactory.lectures.homework1.model.UserModels;
import hr.dreamfactory.lectures.homework1.model.common.User;
import hr.dreamfactory.lectures.homework1.model.common.Users;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.util.List;

public class HttpRepository implements Users {
    private final long size;
    private String urlPath;
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private UserModels results;

    public HttpRepository(String urlPath, Long size) throws Exception {
        this.size = size;
        this.urlPath = urlPath;
        results = new UserModels();
        sendGet();
    }

    @Override
    public List<? extends User> getRandomUsers() {
        return results.getResults();
    }

    private void sendGet() throws Exception {
        URI uri = new URIBuilder(urlPath)
                .setPath("api/")
                .setParameter("results", "10")
                .build();

        HttpGet request = new HttpGet(uri);

        try (CloseableHttpResponse response =  httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            results = new Gson().fromJson(result, UserModels.class);
        }

    }




}
