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

    public void create(User user){
        users.add(user);
    }

    public List<User> find(String country){
        return users.stream()
                .filter(t -> t.getNationality().equals(country))
                .collect(Collectors.toList());
    }
    public List<User> getUsers(int limit){
        return users.stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    public void loadUsers(List<User> users){
        this.users = users;
    }

}
