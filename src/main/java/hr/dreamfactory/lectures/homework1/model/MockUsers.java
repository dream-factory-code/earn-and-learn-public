package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.common.Users;

import java.util.ArrayList;
import java.util.List;

public class MockUsers implements Users {
    private List<User> userList = new ArrayList<>();

    @Override
    public List<User> getRandomUsers() {
        int numOfUsers = (int) (Math.random() * 100 + 1);
        for (int i = 0; i < numOfUsers; ++i) {
            userList.add(new MockUser());
        }
        return userList;
    }
}
