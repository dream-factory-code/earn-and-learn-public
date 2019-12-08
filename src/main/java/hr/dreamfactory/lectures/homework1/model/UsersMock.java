package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.common.Users;

import java.util.ArrayList;
import java.util.List;

public class UsersMock implements Users {

    @Override
    public List<User> getRandomUsers() {
        List<User> randomUsers = new ArrayList<>();

        int randomNumber = (int) (Math.random() * 100) + 1;

        for (int i = 0; i < randomNumber; i++) {
            randomUsers.add(new UserMock());
        }

        return randomUsers;
    }
}
