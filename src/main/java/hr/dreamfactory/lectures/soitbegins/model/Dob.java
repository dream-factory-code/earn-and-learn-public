package hr.dreamfactory.lectures.soitbegins.model;

import com.univocity.parsers.annotations.Parsed;

public class Dob {
    @Parsed
    private String date;

    @Parsed
    private String age;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
