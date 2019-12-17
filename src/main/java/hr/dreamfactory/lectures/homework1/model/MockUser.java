package hr.dreamfactory.lectures.homework1.model;

public class MockUser extends User {
    private String firstName;
    private String lastName;
    private String location;

    public MockUser() {
        firstName = "Vice";
        lastName = "Šimunov";
        location = "Bali, Somewhere on Bali";
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
