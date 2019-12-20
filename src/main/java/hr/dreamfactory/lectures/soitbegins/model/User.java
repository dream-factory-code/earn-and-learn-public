package hr.dreamfactory.lectures.soitbegins.model;

import com.google.gson.annotations.SerializedName;
import com.univocity.parsers.annotations.Nested;
import com.univocity.parsers.annotations.Parsed;

public class User {

    @Nested
    private Name name;

    @Nested
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
}
