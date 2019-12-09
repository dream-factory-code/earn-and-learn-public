package hr.dreamfactory.homework01.model;


import hr.dreamfactory.homework01.common.User;

public class UserModel implements User {

    private Name name;
    private Location location;

    public UserModel(){}

    @Override
    public String fullname() {
        StringBuilder fullName = new StringBuilder(name.getFirst())
                .append(" ")
                .append(name.getLast());
        return fullName.toString();
    }

    @Override
    public String location() {
        StringBuilder loc = new StringBuilder(location.getCity())
                .append(", ")
                .append(location.getCountry());
        return loc.toString();
    }

    @Override
    public String toString() {
        return "UserImpl{" +
                "name=" + name +
                ", location=" + location +
                '}';
    }
}
