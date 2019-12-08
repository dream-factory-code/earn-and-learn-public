package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.common.Users;

import java.util.List;

public class UsersModel implements Users {

    List<User> users;

    @Override
    public List<User> getRandomUsers() {
        return users;
    }
}
