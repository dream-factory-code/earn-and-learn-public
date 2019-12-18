package hr.dreamfactory.lectures.homework1.model;

import hr.dreamfactory.lectures.homework1.services.CSVService;
import hr.dreamfactory.lectures.homework1.model.mocks.UserMock;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class UserMockTest {

    @Test
    public void deserializeTest() {
        CSVService service = new CSVService();
        UserMock userMock = new UserMock();
        Assert.assertEquals("\"Marko Markić\", \"Zagreb, Croatia\"", service.serializeToCSV(userMock));
    }

    @Test
    public void testLuka(){
        try (Luka luka = new Luka()) {

        } catch (IOException e) {
            // haha
        }
    }

}