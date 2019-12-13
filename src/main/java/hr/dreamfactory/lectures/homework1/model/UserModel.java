package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.model.common.User;

public class UserModel implements User {
    private Name name;
    private Location location;

    @Override
    public String fullName() {
        StringBuilder fullname = new StringBuilder(name.getFirst())
                .append(" ")
                .append(name.getLast());
        return fullname.toString();
    }

    @Override
    public String location() {
        StringBuilder loc = new StringBuilder(location.getCity())
                .append(", ")
                .append(location.getCountry());
        return loc.toString();
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name=" + name +
                ", location=" + location +
                '}';
    }
}