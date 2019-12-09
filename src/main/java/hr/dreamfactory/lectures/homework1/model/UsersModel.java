package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.common.Users;

import java.util.ArrayList;
import java.util.List;

public class UsersModel implements Users{

    private List<UserModel> results;

    public UsersModel() {
        results = new ArrayList<>();
    }

    public UsersModel(List<UserModel> results) {
        this.results = results;
    }

    public void setResults(List<UserModel> results) {
        this.results = results;
    }

    public List<UserModel> getResults() {
        return results;
    }

    public void setUsers(List<UserModel> users) {
        this.results = users;
    }

    @Override
    public List<User> getRandomUsers() {
        return null;
    }

    public String serializeUsers() {
        StringBuilder serialize = new StringBuilder();
        if (results.size() < 1){
            return "List of users is empty.";
        }
        for (User user : results) {
            serialize.append(user.fullName() + ", \"" + user.location() + "\"\n");
        }

        return serialize.toString();
    }
}
