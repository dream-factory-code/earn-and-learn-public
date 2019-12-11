package hr.dreamfactory.lectures.homework1.common;

public interface User {
    String fullName();
    String location();

    default String buildCSVString() {
        return "\"" + this.fullName() + "\", \"" + this.location() + "\"";
    }
}
