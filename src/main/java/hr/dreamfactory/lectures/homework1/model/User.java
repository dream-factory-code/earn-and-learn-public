package hr.dreamfactory.lectures.homework1.model;

import com.google.gson.annotations.SerializedName;
import com.univocity.parsers.annotations.Nested;
import com.univocity.parsers.annotations.Parsed;

import javax.ws.rs.Path;

public class User {

    private Name name;

    private Location location;

    @Parsed
    private String gender;

    @Parsed
    private String phone;

    @Parsed
    @SerializedName("nat")
    private String nationality;

    @Nested
    @SerializedName("dob")
    private Dob date;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Dob getDate() {
        return date;
    }

    public void setDate(Dob date) {
        this.date = date;
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

    @Parsed(field = "fullname", index = 0)
    public String fullName() {
        return String.format(name.getFirst() + " " + name.getLast());
    }

    @Parsed(field = "location", index = 1)
    public String location() {
        return String.format(location.getCity() + ", " + location.getCountry());
    }
}
