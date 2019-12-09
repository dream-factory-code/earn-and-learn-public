package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.common.Users;

import java.util.ArrayList;
import java.util.List;

public class UserModels implements Users {
    private List<UserModel> results;

    public List<UserModel> getResults() {
        return results;
    }

    @Override
    public List<User> getRandomUsers() {
        List<User> users = new ArrayList<>();
        for (UserModel userModel : results) {
            users.add(userModel);
        }
        return users;
    }

    public void setResults(List<UserModel> results) {
        this.results = results;
    }
}

