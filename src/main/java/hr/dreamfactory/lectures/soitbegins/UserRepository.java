package hr.dreamfactory.lectures.soitbegins;

import hr.dreamfactory.lectures.soitbegins.model.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository(List<User> users) {
        this.users = users;
    }

    public UserRepository() {
    }

    private void create(User user){
        users.add(user);
    }

    private List<User> find(String country){
        return users.stream()
                .filter(t -> t.getNationality().equals(country))
                .collect(Collectors.toList());
    }

}
