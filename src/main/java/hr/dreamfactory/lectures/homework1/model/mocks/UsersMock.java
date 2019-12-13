package hr.dreamfactory.lectures.homework1.model.mocks;

import hr.dreamfactory.lectures.homework1.model.common.User;
import hr.dreamfactory.lectures.homework1.model.common.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UsersMock implements Users {

    @Override
    public List<User> getRandomUsers() {
        List<User> randomUsers = new ArrayList<>();
        Random random = new Random();
        int randomNumber = random.nextInt(90) + 10;

        for (int i = 0; i < randomNumber; i++) {
            randomUsers.add(new UserMock());
        }

        return randomUsers;
    }
}
