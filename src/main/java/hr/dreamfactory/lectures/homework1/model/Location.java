package hr.dreamfactory.lectures.homework1.model;

import com.univocity.parsers.annotations.Parsed;

public class Location {

    @Parsed
    private String city;

    @Parsed
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
