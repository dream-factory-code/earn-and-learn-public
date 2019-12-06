package hr.dreamfactory.lectures.vice;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzSampleTest {


    @Test
    void smokeTest() {
        String result = FizzBuzzSample.listNumbers(3);

        Assert.assertEquals("1\n2\nfizz\n", result);
    }

    @Test
    void testCornerCaseZero(){
        String result = FizzBuzzSample.listNumbers(0);

        Assert.assertEquals("", result);
    }

    @Test
    void loadTest(){
        FizzBuzzSample.listNumbers(1_000_000);
    }
}