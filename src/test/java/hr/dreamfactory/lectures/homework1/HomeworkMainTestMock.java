package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.model.MockUser;
import hr.dreamfactory.lectures.homework1.model.MockUsers;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class HomeworkMainTestMock {

    @Test
    public void nameTest() {
        String expected = "Ena Fra";
        MockUser user1 = new MockUser();
        Assert.assertEquals(expected, user1.fullName());
    }

    @Test
    public void locationTest() {
        String expected = "Zagreb, Croatia";
        MockUser user2 = new MockUser();
        Assert.assertEquals(expected, user2.location());
    }

    @Test
    public void mockUsersListTest() {
        MockUsers users = new MockUsers();
        users.addMockUser(new MockUser());
        String result = users.serializeUserList();
        String expected = "Ena Fra \"Zagreb, Croatia\"\n";
        Assert.assertEquals(expected, result);
    }

    @Test
    @Disabled
    public void writeToCSVTest() {
        MockUsers users1 = new MockUsers();
        users1.addMockUser(new MockUser());
        users1.addMockUser(new MockUser());
        String result = users1.serializeUserList();
        HomeworkMain.writeToCSV(result);
    }

    @Test
    public void nullSerializeTest() {
        MockUsers users2 = new MockUsers();
        String expected = "List of users is empty.";
        String result = users2.serializeUserList();
         Assert.assertEquals(expected, result);
    }

    @Test
    public void nullCSVTest() {
        MockUsers users3 = new MockUsers();
        String serialize = users3.serializeUserList();
        HomeworkMain.writeToCSV(serialize);
    }
}