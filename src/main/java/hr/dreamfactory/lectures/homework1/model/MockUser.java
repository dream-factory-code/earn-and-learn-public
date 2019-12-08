package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.User;

public class MockUser implements User {
    public String fullName() {
        return "Petra Fribert";
    }

    public String location() {
        return "Zagreb, Croatia";
    }

    public String serializeUserToCSV(){
        return fullName() + ", " + location();
    }
}
