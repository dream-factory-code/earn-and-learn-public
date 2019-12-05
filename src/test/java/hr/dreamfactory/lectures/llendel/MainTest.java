package hr.dreamfactory.lectures.llendel;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void smokeTest() {
        String result = Main.fizzBuzz(3);

        assertEquals("1\n2\nfizz\n", result);
    }

    @Test
    void loadTest() {
        Main.fizzBuzz(50000000);
    }
}