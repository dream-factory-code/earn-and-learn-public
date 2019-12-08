package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.User;

import java.util.Map;

public class UserModel implements User {

    private Name fullName;
    private Location location;

    @Override
    public String fullName() {
        return String.format(fullName.getTitle() + " " + fullName.getFirst() + " " + fullName.getLast());
    }

    @Override
    public String location() {
        return String.format(location.getCity() + " " + location.getCountry());
    }
}
