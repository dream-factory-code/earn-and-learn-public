import hr.dreamfactory.lectures.homework1.HomeworkMain;
import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.model.MockUser;
import hr.dreamfactory.lectures.homework1.model.MockUsers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class WriterTests {
    @Test
    public void noUsersTest() {
        final String expected = "fullname, location";
        final String actual = HomeworkMain.listToCsv(new ArrayList<User>());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void singleUserTest() {
        MockUsers users = new MockUsers();
        users.addUser(new MockUser("Ivan", "Ivanović", "Ivanić Grad, Croatia"));

        final String expected = "fullname, location\n" +
                "\"Ivan Ivanović\", \"Ivanić Grad, Croatia\"";
        final String actual = HomeworkMain.listToCsv(users.getRandomUsers());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void multipleUsersTest() {
        MockUsers users = new MockUsers();
        users.addUser(new MockUser("Ivan", "Ivanović", "Ivanić Grad, Croatia"));
        users.addUser(new MockUser("Ivan", "Ivanović", "Ivanić Grad, Croatia"));
        users.addUser(new MockUser("Ivan", "Ivanović", "Ivanić Grad, Croatia"));

        final String expected = "fullname, location\n" +
                "\"Ivan Ivanović\", \"Ivanić Grad, Croatia\"\n" +
                "\"Ivan Ivanović\", \"Ivanić Grad, Croatia\"\n" +
                "\"Ivan Ivanović\", \"Ivanić Grad, Croatia\"";
        final String actual = HomeworkMain.listToCsv(users.getRandomUsers());

        Assert.assertEquals(expected, actual);
    }
}
