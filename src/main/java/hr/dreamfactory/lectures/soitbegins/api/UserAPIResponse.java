package hr.dreamfactory.lectures.soitbegins.api;

import hr.dreamfactory.lectures.soitbegins.model.User;

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
