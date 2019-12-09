
package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.common.User;

import java.util.Map;

public class UserModel implements User {

    private Name fullName;
    private Location location;

    @Override
    public String fullName() {
        return String.format(fullName.getFirstName() + " " + fullName.getLastName());
    }

    @Override
    public String location() {
        return String.format(location.getCity() + " " + location.getCountry());
    }
}