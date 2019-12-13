package hr.dreamfactory.lectures.homework1.service;

import hr.dreamfactory.lectures.homework1.model.mocks.UserMock;
import hr.dreamfactory.lectures.homework1.services.CSVService;
import org.junit.After;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVServiceTest {
    public static final Path PATH = Paths.get("test.csv");
    private CSVService service = new CSVService();

    @After
    public void cleanup(){
        if(PATH.toFile().exists()){
            PATH.toFile().delete();
        }
    }

    @Test(expected = NullPointerException.class)
    public void bothArgumentsNullTest() {
        service.writeToCSVFile(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void firstArgumentNullTest() {
        List<UserMock> users = new ArrayList<>();
        users.add(new UserMock());
        service.writeToCSVFile(null, users);
    }


    @Test()
    public void writeToCSVFile_happyPath() {
        List<UserMock> users = new ArrayList<>();
        users.add(new UserMock());
        service.writeToCSVFile(PATH, users);
    }

    @Test(expected = NullPointerException.class)
    public void secondArgumentNullTest() {
        service.writeToCSVFile(Paths.get("./ducks.csv"), null);
    }

    @Test
    public void nonExistingPathTest() {
        service.writeToCSVFile(Paths.get("./nesto/ducks.csv"), new ArrayList<>());
    }

    @Test
    public void emptyListTest() {
        service.writeToCSVFile(Paths.get("./ducks.csv"), new ArrayList<>());
    }

}