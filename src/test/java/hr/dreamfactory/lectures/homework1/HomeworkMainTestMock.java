package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.model.MockUser;
import hr.dreamfactory.lectures.homework1.model.MockUsers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkMainTestMock {

    @Test
    public void nameTest() {
        String expected = "Ena Fra";
        MockUser user = new MockUser();
        Assert.assertEquals(expected, user.fullName());
    }

    @Test
    public void locationTest() {
        String expected = "Zagreb, Croatia";
        MockUser user = new MockUser();
        Assert.assertEquals(expected, user.location());
    }

    @Test
    public void mockUsersListTest() {
        MockUsers users = new MockUsers();
        Assert.assertNotNull(users.getRandomUsers());
    }

}