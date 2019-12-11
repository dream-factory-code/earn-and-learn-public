package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.controllers.UsersToCSV;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class UsersToCSVTest {
    private UsersToCSV usersToCSV;

    @Before
    public void setup(){
        usersToCSV = new UsersToCSV("chicken.csv", new MockUsers());
    }

    @Test
    public void serializeUsers_noUsersTest() {
        final String expected = "fullname, location";
        final String actual = usersToCSV.serializeUsers(new ArrayList<>());

        assertEquals(expected, actual);
    }

    @Test
    public void serializeUsers_singleUserTest() {
        MockUsers users = new MockUsers(new ArrayList<>());
        users.addUser(new MockUser("Ivan", "Ivanović", "Ivanić Grad, Croatia"));

        final String expected = "fullname, location\n" +
                "\"Ivan Ivanović\", \"Ivanić Grad, Croatia\"";
        final String actual = usersToCSV.serializeUsers(users.getRandomUsers());
        assertEquals(expected, actual);
    }

    @Test
    public void serializeUsers_multipleUsersTest() {
        MockUsers users = new MockUsers(new ArrayList<>());
        users.addUser(new MockUser("Ivan", "Ivanović", "Ivanić Grad, Croatia"));
        users.addUser(new MockUser("Ivan", "Ivanović", "Ivanić Grad, Croatia"));
        users.addUser(new MockUser("Ivan", "Ivanović", "Ivanić Grad, Croatia"));

        final String expected = "fullname, location\n" +
                "\"Ivan Ivanović\", \"Ivanić Grad, Croatia\"\n" +
                "\"Ivan Ivanović\", \"Ivanić Grad, Croatia\"\n" +
                "\"Ivan Ivanović\", \"Ivanić Grad, Croatia\"";
        final String actual = usersToCSV.serializeUsers(users.getRandomUsers());

        assertEquals(expected, actual);
    }
}
