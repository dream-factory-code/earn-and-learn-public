package hr.dreamfactory.lectures.soitbegins;

import hr.dreamfactory.lectures.soitbegins.api.RemoteRandomGenerator;
import hr.dreamfactory.lectures.soitbegins.controllers.CSVParser;
import hr.dreamfactory.lectures.soitbegins.model.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository(List<User> users) {
        this.users = users;
        generateId(users);
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


    public List<User> skipAndLimit (int limit, int offset){
        return users.stream()
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());
    }

    public void writeToCSV () {
        CSVParser writer = new CSVParser("chicken-for-tests.csv", new RemoteRandomGenerator());
        writer.writeUsersToCSV(users);
    }
    private void generateId(List<User> users){
        users.forEach(user -> {
            Integer i = 0;
            user.setId(i++);
        });
    }

    public void update(Integer id, User user) {
        delete(id);
        users.add(user);
    }

    public void delete(Integer id) {
        User user = users.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        users.remove(user);

    }

}