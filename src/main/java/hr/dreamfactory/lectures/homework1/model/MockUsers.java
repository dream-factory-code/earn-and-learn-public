package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.UserGenerator;

import java.util.ArrayList;
import java.util.List;

public class MockUsers implements UserGenerator {
    private List<User> users = new ArrayList<>();

    public MockUsers(List<User> users) {
        this.users = users;
    }

    public MockUsers() {
        users.add(new MockUser());
    }

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public List<User> generate() {
        return users;
    }
}
