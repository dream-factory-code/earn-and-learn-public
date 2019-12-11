
package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.User;


public class UserModel implements User {

    private Name name;
    private Location location;

    public UserModel(Name name, Location location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String fullName() {
        return name.getFirstName() + " " + name.getLastName();
    }

    @Override
    public String location() {
        return location.getCity() + ", " + location.getCountry();
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


}