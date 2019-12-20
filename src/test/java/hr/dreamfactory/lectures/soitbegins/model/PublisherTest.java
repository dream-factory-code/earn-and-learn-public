package hr.dreamfactory.lectures.soitbegins.model;


import org.junit.Test;

public class PublisherTest {

    @Test
    public void test(){
        Publisher publisher = new Publisher();
        LoggingObserver observer = new LoggingObserver();
        LoggingObserver observer2 = new LoggingObserver();
        LoggingObserver observer3 = new LoggingObserver();

        publisher.add(observer);
        publisher.add(observer2);
        publisher.add(observer3);

        publisher.doStuff();
    }


}