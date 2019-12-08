package hr.dreamfactory.lectures.homework1.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserMockTest {

    @Test
    public void deserializeTest() {
        UserMock userMock = new UserMock();
        Assertions.assertEquals("\"Marko Markić\", \"Zagreb, Croatia\"", userMock.serializeToCSV());
    }

}