package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.User;

public class UserMock implements User {

    @Override
    public String fullName() {
        return "Marko Markić";
    }

    @Override
    public String location() {
        return "Zagreb, Croatia";
    }

    public String serializeToCSV() {
        return "\"" + fullName() + "\", \"" + location() + "\"";
    }
}
