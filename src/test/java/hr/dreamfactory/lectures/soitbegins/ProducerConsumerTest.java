
package hr.dreamfactory.lectures.soitbegins;

import org.junit.Assert;
import org.junit.Test;

public class ProducerConsumerTest {

    @Test
    public void runConsumers() throws InterruptedException {
        ProducerConsumer consumer = new ProducerConsumer();
        consumer.start();

        for(int i = 0; i < 100000; i++){
            consumer.produce();
        }

        consumer.stop();
    }
}