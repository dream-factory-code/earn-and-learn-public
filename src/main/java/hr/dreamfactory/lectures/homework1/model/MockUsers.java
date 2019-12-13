package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.common.Users;

import java.util.ArrayList;
import java.util.List;

public class MockUsers implements Users {
    private List<User> userList = new ArrayList<>();

    @Override
    public List<User> getRandomUsers() {
        return userList;
    }

    public void addMockUser(MockUser user) {
        userList.add(user);
    }

    public String serializeMockUserList() {
        StringBuilder serialize = new StringBuilder();

        for (User user : userList) {
            serialize.append(user.fullName() + ", \"" + user.location() + "\"\n");
        }

        return serialize.toString();
    }

}
