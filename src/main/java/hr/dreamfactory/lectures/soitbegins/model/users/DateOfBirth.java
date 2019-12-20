package hr.dreamfactory.lectures.soitbegins.model.users;

import com.univocity.parsers.annotations.Parsed;

import java.time.ZonedDateTime;

public class DateOfBirth {
    @Parsed
    private ZonedDateTime date;

    @Parsed
    private String age;

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
