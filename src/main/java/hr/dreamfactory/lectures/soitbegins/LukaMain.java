package hr.dreamfactory.lectures.soitbegins;

import hr.dreamfactory.lectures.soitbegins.api.RemoteRandomGenerator;
import hr.dreamfactory.lectures.soitbegins.controllers.CSVParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LukaMain {
    public static void main(String[] args) {
        SpringApplication.run(LukaMain.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            CSVParser parser = new CSVParser("chicken-for-tests.csv", new RemoteRandomGenerator());
            UserRepository repo = new UserRepository(parser.parse("chicken-for-tests.csv"));
            };

        };
}
