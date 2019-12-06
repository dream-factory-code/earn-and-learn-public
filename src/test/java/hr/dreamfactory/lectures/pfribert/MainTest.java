package hr.dreamfactory.lectures.pfribert;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzSampleTest {

    @Test
    void smokeTest() {
        String result = Main.fizzBuzzer(3);
        assertEquals("1\n2\nfizz\n", result);
    }

    @Test
    void testCornerZero() {
        String result = Main.fizzBuzzer(0);
        assertEquals("", result);
    }

    @Test
    void loadTest() {
        Main.fizzBuzzer(50);
    }
}