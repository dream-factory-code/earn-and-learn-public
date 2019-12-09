package hr.dreamfactory.lectures1.homework1;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeworkRealMainTest {

    @Test
    void smokeTest() {
        String result = HomeworkRealMain.getRandomUser(5);

        assertEquals(5, result.split("\"location\"",-1).length-1);
    }

    @Test
    void loadTest() {
        HomeworkRealMain.getRandomUser(10_000);

    }


}
