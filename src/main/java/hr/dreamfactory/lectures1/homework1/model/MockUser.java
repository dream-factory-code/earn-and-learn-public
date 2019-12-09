package hr.dreamfactory.lectures1.homework1.model;

import hr.dreamfactory.lectures1.homework1.common.User;

public class MockUser implements User {
    private String firstName;
    private String lastName;
    private String location;

    public MockUser() {
    }

    public MockUser(String firstName, String lastName, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }

    @Override
    public String fullName() {
        return String.format(firstName + " " + lastName);
    }

    @Override
    public String location() {
        return location;
    }
}
