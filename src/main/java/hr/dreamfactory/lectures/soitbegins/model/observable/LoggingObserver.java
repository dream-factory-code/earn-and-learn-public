package hr.dreamfactory.lectures.soitbegins.model.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingObserver implements Observer {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingObserver.class);

    @Override
    public void update() {
        LOGGER.info("Updated observer");
    }
}
