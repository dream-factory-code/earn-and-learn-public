package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.common.Users;

import java.util.ArrayList;
import java.util.List;

public class UsersModel implements Users {

    private List<User> users;

    public UsersModel() {
        users = new ArrayList<>();
    }

    @Override
    public List<User> getRandomUsers() {
        return users;
    }

    public UsersModel(List<User> results) {
        this.users = results;
    }

    public void setResults(List<User> results) {
        this.users = results;
    }
}
