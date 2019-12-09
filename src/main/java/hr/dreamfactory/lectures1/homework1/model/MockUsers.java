package hr.dreamfactory.lectures1.homework1.model;

import hr.dreamfactory.lectures1.homework1.common.User;
import hr.dreamfactory.lectures1.homework1.common.Users;

import java.util.ArrayList;
import java.util.List;

public class MockUsers implements Users {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public List<User> getRandomUsers() {
        return users;
    }
}
