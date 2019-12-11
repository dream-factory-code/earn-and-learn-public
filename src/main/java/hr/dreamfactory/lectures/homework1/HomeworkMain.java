package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.common.Users;
import hr.dreamfactory.lectures.homework1.model.MockUsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HomeworkMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeworkMain.class);

    public static void main(String[] args) {
        Users repository = new MockUsers();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("chicken.csv"))) {
            writer.write(serializeUsers(repository.getRandomUsers()));
            LOGGER.info("Users written to .csv");
        } catch (IOException e) {
            LOGGER.error("Something went wrong :( ", e);
        }
    }

    public static String serializeUsers(List<? extends User> users) {
        StringBuilder result = new StringBuilder();

        result.append("fullname, location");

        for (User user : users) {
            String line = String.format("\n\"" + user.fullName() + "\"" + ", " + "\"" + user.location() + "\"");
            result.append(line);
        }

        return result.toString();
    }
}
