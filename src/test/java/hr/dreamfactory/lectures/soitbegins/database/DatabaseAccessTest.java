package hr.dreamfactory.lectures.soitbegins.database;

import hr.dreamfactory.lectures.soitbegins.model.users.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseAccessTest {

    @Test
    void checkConnection() {
        DatabaseAccess databaseAccess = new DatabaseAccess();
        Assert.assertEquals(new Integer(1), databaseAccess.checkConnection());
    }

    @Test
    void insertPartial() {
        DatabaseAccess databaseAccess = new DatabaseAccess();
        User user = new User();
        user.setGender("female");
        user.setPhone("09924242");
        user.setNationality("Croatian");

        databaseAccess.insertPartial(user);

    }


    @Test
    void selectAll() {
        DatabaseAccess databaseAccess = new DatabaseAccess();

        List<User> users = databaseAccess.selectAll();

        Assert.assertTrue(users.size() > 1);

    }
}