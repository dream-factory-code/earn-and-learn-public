package hr.dreamfactory.lectures.homework1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name {

    @SerializedName("first")
    @Expose
    private String firstName;
    @SerializedName("last")
    @Expose
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
