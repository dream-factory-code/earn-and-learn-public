package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.common.Users;

import java.util.ArrayList;
import java.util.List;

public class UsersModel implements Users {
    List<UserModel> results = new ArrayList<>();

    public List<UserModel> getResults() {
        return results;
    }

    public void setResults(List<UserModel> users) {
        this.results = users;
    }

    @Override
    public List<User> getRandomUsers() {
        List<User> list = new ArrayList<>();
        list.addAll(results);
        return list;
    }
}
