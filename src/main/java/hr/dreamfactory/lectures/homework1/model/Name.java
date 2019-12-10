package hr.dreamfactory.lectures.homework1.model;

import com.google.gson.annotations.SerializedName;

public class Name {

    @SerializedName("first")
    private String firstName;
    @SerializedName("last")
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
