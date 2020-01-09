package hr.dreamfactory.lectures.soitbegins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

public class ProducerConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerConsumer.class);
    public static final int WORKER_CNT = 10;

    private Thread[] consumers;
    private BlockingQueue<OurTask> tasks;

    public ProducerConsumer() {
        consumers = new Thread[WORKER_CNT];
        tasks = new ArrayBlockingQueue<>(100);

        for(int i = 0; i < WORKER_CNT; i++){
            consumers[i] = new Thread(this::consume);
        }
    }

    public void start(){
        Stream.of(consumers)
                .forEach(t -> t.start());
    }

    public void stop() throws InterruptedException {
        for (int i = 0; i < WORKER_CNT; i++){
            tasks.put(new OurTask(null));
        }

        Stream.of(consumers)
                .forEach(t -> {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        LOGGER.error("Woo");
                    }
                });
    }

    public void produce(){
        Random random = new Random();
        int randomInt = random.nextInt(100);

        try {
            LOGGER.info("Producing number: {}", randomInt);
            tasks.put(new OurTask(randomInt));
        } catch (InterruptedException e) {
            // nothing will happen
        }
    }

    public void consume(){
        while (true){
            try {
                OurTask take = tasks.take();

                if(take.task == null){
                    return;
                }
                LOGGER.info("My number is: {}", take.getTask());
            } catch (InterruptedException e) {
                // will not happen
            }
        }
    }

    private static class OurTask{
        private String task;

        public OurTask(Integer task) {
            if(task != null){
                this.task = String.valueOf(task);
            }
        }

        public String getTask() {
            return task;
        }
    }
}
