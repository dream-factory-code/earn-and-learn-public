package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.User;

public class UserModel implements User {

    private Name name;

    private Location location;

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
    public String fullName() {
        return String.format(name.getFirst() + " " + name.getLast());
    }

    @Override
    public String location() {
        return String.format(location.getCity() + ", " + location.getCountry());
    }
}
