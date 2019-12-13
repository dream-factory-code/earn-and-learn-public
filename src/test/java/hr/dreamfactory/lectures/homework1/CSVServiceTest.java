package hr.dreamfactory.lectures.homework1;

import org.junit.Before;
import org.junit.Test;


public class CSVServiceTest {

    private CSVService service;

    @Before
    public void setup(){
        service = new CSVService();
    }


    @Test(expected = NullPointerException.class)
    public void serializeUsers_Null() {
        service.serializeUsers(null);
    }
}