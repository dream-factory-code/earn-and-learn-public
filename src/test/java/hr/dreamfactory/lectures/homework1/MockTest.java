package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.model.MockUser;
import hr.dreamfactory.lectures.homework1.model.MockUsers;
import org.junit.*;

import java.io.File;

public class MockTest {
    private CSVService service;
    private static final String GEESE = "./geese.csv";

    @Before
    public void setup(){
        service = new CSVService();
    }

    @After
    public void cleanup(){
        File file = new File(GEESE);
        if(file.exists()){
            file.delete();
        }
    }

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
        users.addMockUser(new MockUser());
        String result = service.serializeUsers(users.getRandomUsers());
        String expected = "\"Ena Fra\", \"Zagreb, Croatia\"";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void writeToCSVTest() {
        MockUsers userList = new MockUsers();
        userList.addMockUser(new MockUser());
        userList.addMockUser(new MockUser());
        String result = service.serializeUsers(userList.getRandomUsers());
        service.writeToCSV(result,GEESE);
    }

    @Test
    public void nullSerializeTest() {
        MockUsers userList = new MockUsers();
        String result = service.serializeUsers(userList.getRandomUsers());
        Assert.assertEquals("", result);
    }

    @Test
    public void nullCSVTest() {
        MockUsers userList = new MockUsers();
        String serialize = userList.serializeMockUserList();
        service.writeToCSV(serialize, GEESE);
    }
}