package hr.dreamfactory.lectures.bbilic;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void smokeTest() {
        String result = Main.fizzBuzzer(5);
        Assert.assertEquals("1\n2\nfizz\n4\nbuzz\n", result);
    }

    @Test
    void testCornerCaseZero() {
        String result = Main.fizzBuzzer(0);
        Assert.assertEquals("", result);
    }

    @Test
    void testNegative() {
        String result = Main.fizzBuzzer(-1);
        Assert.assertEquals("", result);
    }

    @Test
    void testForThree() {
        String result = Main.fizzBuzzer(3);
        Assert.assertEquals("1\n2\nfizz\n", result);
    }

    @Test
    void testForBigNumber() {
        String result = Main.fizzBuzzer(50_000_000);
    }
}