package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.common.Users;

import java.util.List;

public class UsersModel implements Users {

    List<User> results;

    public UsersModel() {
    }

    @Override
    public List<User> getRandomUsers() {
        return results;
    }

    public UsersModel(List<User> results) {
        this.results = results;
    }

    public List<User> getResults() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }
}
