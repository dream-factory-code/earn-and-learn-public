package hr.dreamfactory.lectures.homework1.model;

import com.univocity.parsers.annotations.Nested;
import com.univocity.parsers.annotations.Parsed;
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
    @Parsed(field = "fullname")
    public String fullName() {
        return String.format(name.getFirst() + " " + name.getLast());
    }

    @Parsed(field = "location")
    @Override
    public String location() {
        return String.format(location.getCity() + ", " + location.getCountry());
    }
}
