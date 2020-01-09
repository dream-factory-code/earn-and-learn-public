package hr.dreamfactory.lectures.threading;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.*;

public class ThreadsTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadsTest.class);

    private static void runSomething() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            LOGGER.info("Moja lambda", e);
            Thread.currentThread().interrupt();
        }
        LOGGER.info("Hello from thread!");
    }

    private static void exceptSomething() {
        throw new RuntimeException("BOO!, I'm ded");
    }

    @Test
    public void something_1_2() throws Exception {
        Thread thread = new Thread(ThreadsTest::exceptSomething, "bubu");
        thread.start();

        LOGGER.info("Hello from main!");
        thread.join();
    }

    @Test
    public void executorTest() throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        ScheduledFuture<?> future = executorService.schedule(() -> LOGGER.info("CAPS LOCK IS ON"), 10, TimeUnit
                .SECONDS);

        future.get();

    }

    @Test
    public void completableFuture() {
        CompletableFuture<Void> first = CompletableFuture.runAsync(() -> LOGGER.info("Hello from future"));

        CompletableFuture<Void> accept = CompletableFuture.supplyAsync(() -> 0)
                .thenAccept(t -> LOGGER.info("The zero: {}", t));

        CompletableFuture<Void> second = CompletableFuture.runAsync(() -> LOGGER.info("Hello from future 2"));

        CompletableFuture.allOf(first, second, accept);
    }
}
