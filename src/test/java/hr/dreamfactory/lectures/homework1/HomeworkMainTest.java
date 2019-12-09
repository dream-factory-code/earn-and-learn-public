package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.model.UserMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class HomeworkMainTest {

    @Test
    public void bothArgumentsNullTest() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            HomeworkMain.writeToCSVFile(null, null);
        });
    }

    @Test
    @Disabled
    public void firstArgumentNullTest() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            List<UserMock> users = new ArrayList<>();
            users.add(new UserMock());
        });
    }

    @Test
    public void secondArgumentNullTest() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            HomeworkMain.writeToCSVFile(Paths.get("./ducks.csv"), null);
        });
    }

    @Test
    public void nonExistingPathTest() {
        //Logger will write exception to standard output
        HomeworkMain.writeToCSVFile(Paths.get("./nesto/ducks.csv"), new ArrayList<>());
    }

    @Test
    public void emptyListTest() {
        HomeworkMain.writeToCSVFile(Paths.get("./ducks.csv"), new ArrayList<>());
    }

}