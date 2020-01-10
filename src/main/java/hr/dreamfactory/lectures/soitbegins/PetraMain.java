package hr.dreamfactory.lectures.soitbegins;

import hr.dreamfactory.lectures.soitbegins.api.RemoteRandomGenerator;
import hr.dreamfactory.lectures.soitbegins.controllers.CSVParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PetraMain {
    private static final Logger LOGGER =  LoggerFactory.getLogger(PetraMain.class);
    public static void main(String[] args) {
        SpringApplication.run(PetraMain.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            RemoteRandomGenerator generator = new RemoteRandomGenerator();
            CSVParser parser = new CSVParser("chicken-for-tests", generator);
            UserRepository repository = new UserRepository(parser.parse());
            LOGGER.info("Repository is filled.");
        };
    }
}
