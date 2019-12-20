package hr.dreamfactory.lectures.soitbegins.model.users;

import com.univocity.parsers.annotations.Parsed;

public class Name {

    @Parsed
    private String first;

    @Parsed
    private String last;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
