package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.api.ApacheUserAPI;
import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.common.Users;

import java.util.List;

public class ApacheUsersRepository implements Users {
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
    public List<? extends User> getRandomUsers() {
        return api.getUsers(results).getResults();
    }
}
