package hr.dreamfactory.lectures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void smokeTest(){
        String result = Main.fizBuz(3);
        assertEquals( "1\n2\nfizz\n", result);
    }

    @Test
    void secondTest() {
        String result = Main.fizBuz(0);
        assertEquals("", result);
    }

     @Test
     void loadTest(){
          Main.fizBuz(50_000_000);
        }



}