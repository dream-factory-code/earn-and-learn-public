package hr.dreamfactory.lectures.soitbegins.common;

import hr.dreamfactory.lectures.soitbegins.model.users.User;

import java.util.List;

public interface UserGenerator {
    List<User> generate();
}