package hr.dreamfactory.lectures;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void smokeTest() {
        String result = Main.fizBuz(3);

        assertEquals("1\n2\nfizz\n", result);
    }

    @Test
    public void loadTest() {
        Main.fizBuz(50000000);
    }

}