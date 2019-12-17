package hr.dreamfactory.lectures.homework1.model;

import com.univocity.parsers.annotations.Nested;
import com.univocity.parsers.annotations.Parsed;

import java.sql.Timestamp;

public class Dob {
    @Parsed
    private Timestamp date;
    @Parsed
    private String age;

    public Dob(Timestamp date) {
        this.date = date;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
