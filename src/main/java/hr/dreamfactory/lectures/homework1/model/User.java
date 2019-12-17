package hr.dreamfactory.lectures.homework1.model;

import com.univocity.parsers.annotations.Parsed;

public class User {

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

    @Parsed(field = "fullname", index = 0)
    public String fullName() {
        return String.format(name.getFirst() + " " + name.getLast());
    }

    @Parsed(field = "location", index = 1)
    public String location() {
        return String.format(location.getCity() + ", " + location.getCountry());
    }
}
