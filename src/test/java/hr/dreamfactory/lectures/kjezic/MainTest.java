package hr.dreamfactory.lectures.kjezic;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void smokeTest() {
        String result = Main.fizzBuzz(3);

        Assert.assertEquals("1\n2\nfizz\n", result);
    }

    @Test
    void testCornerCaseZero() {
        String result = Main.fizzBuzz(0);

        Assert.assertEquals("", result);
    }

    @Test
    void testCornerCaseNegative() {
        String result = Main.fizzBuzz(-1);

        Assert.assertEquals("", result);
    }

    @Test
    void loadTest(){
        Main.fizzBuzz(50_000_000);
    }

}