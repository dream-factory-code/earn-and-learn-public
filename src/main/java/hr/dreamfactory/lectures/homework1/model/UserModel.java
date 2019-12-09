
package hr.dreamfactory.lectures.homework1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import hr.dreamfactory.lectures.homework1.common.User;

import java.util.Map;

public class UserModel implements User {

    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("location")
    @Expose
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
        return location.getCity() + " " + location.getCountry();
    }
}