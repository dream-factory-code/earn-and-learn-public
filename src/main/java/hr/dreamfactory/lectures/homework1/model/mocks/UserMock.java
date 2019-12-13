package hr.dreamfactory.lectures.homework1.model.mocks;

import hr.dreamfactory.lectures.homework1.model.common.User;

public class UserMock implements User {

    @Override
    public String fullName() {
        return "Marko Markić";
    }

    @Override
    public String location() {
        return "Zagreb, Croatia";
    }
}
