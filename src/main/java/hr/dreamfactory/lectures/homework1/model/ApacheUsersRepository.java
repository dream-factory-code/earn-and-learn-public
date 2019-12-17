package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.api.ApacheUserAPI;
import hr.dreamfactory.lectures.homework1.common.UserGenerator;

import java.util.List;

public class ApacheUsersRepository implements UserGenerator {
    public final int results;
    private final ApacheUserAPI api;

    public ApacheUsersRepository() {
        this(10);
    }

    public ApacheUsersRepository(int results) {
        this.results = results;
        api = new ApacheUserAPI();
    }

    @Override
    public List<User> generate() {
        return api.getUsers(results).getResults();
    }
}
