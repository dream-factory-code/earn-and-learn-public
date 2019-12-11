package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.HomeworkMain;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class WriterTests {
    @Test
    public void noUsersTest() {
        final String expected = "fullname, location";
        final String actual = HomeworkMain.serializeUsers(new ArrayList<>());

        assertEquals(expected, actual);
    }

    @Test
    public void singleUserTest() {
        MockUsers users = new MockUsers(new ArrayList<>());
        users.addUser(new MockUser("Ivan", "Ivanović", "Ivanić Grad, Croatia"));

        final String expected = "fullname, location\n" +
                "\"Ivan Ivanović\", \"Ivanić Grad, Croatia\"";
        final String actual = HomeworkMain.serializeUsers(users.getRandomUsers());
        assertEquals(expected, actual);
    }

    @Test
    public void multipleUsersTest() {
        MockUsers users = new MockUsers(new ArrayList<>());
        users.addUser(new MockUser("Ivan", "Ivanović", "Ivanić Grad, Croatia"));
        users.addUser(new MockUser("Ivan", "Ivanović", "Ivanić Grad, Croatia"));
        users.addUser(new MockUser("Ivan", "Ivanović", "Ivanić Grad, Croatia"));

        final String expected = "fullname, location\n" +
                "\"Ivan Ivanović\", \"Ivanić Grad, Croatia\"\n" +
                "\"Ivan Ivanović\", \"Ivanić Grad, Croatia\"\n" +
                "\"Ivan Ivanović\", \"Ivanić Grad, Croatia\"";
        final String actual = HomeworkMain.serializeUsers(users.getRandomUsers());

        assertEquals(expected, actual);
    }
}
