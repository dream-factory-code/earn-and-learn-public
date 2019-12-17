package hr.dreamfactory.lectures.homework1.api;

import hr.dreamfactory.lectures.homework1.model.User;

import java.util.List;

public class UserAPIResponse {
    private List<User> results;

    public List<User> getResults() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }
}
