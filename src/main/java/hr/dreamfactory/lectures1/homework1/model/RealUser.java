package hr.dreamfactory.lectures1.homework1.model;

import hr.dreamfactory.lectures1.homework1.common.User;

public class RealUser implements User {

    private String firstName;
    private String lastName;
    private String location;

    public RealUser() {
    }

    public RealUser(String firstName, String lastName, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
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


