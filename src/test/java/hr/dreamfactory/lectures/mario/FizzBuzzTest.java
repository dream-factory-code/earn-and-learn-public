package hr.dreamfactory.lectures.mario;

import static org.junit.jupiter.api.Assertions.*;

import hr.dreamfactory.lectures1.mario.FizzBuzz;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    @Test
    void testCornerCaseZero() {
        String result = FizzBuzz.specialFizzBuzz(0);

        assertEquals("",result);
    }

    @Test
    void smokeTest() {
        String result = FizzBuzz.specialFizzBuzz(5);

        assertEquals("1\n2\nbuzz\n4\nfizz\n",result);
    }

    @Test
    void loadTest(){
        FizzBuzz.specialFizzBuzz(10_000_000);

    }

}