package hr.dreamfactory.lectures.homework1;

import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.model.MockUser;
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
        // Mock classes will be replaced with real models
        MockUsers users = new MockUsers();
        // Data will be fetched from an API
        users.addUser(new MockUser("Ivan", "Ivanovic", "Ivanić Grad, Croatia"));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.csv"))) {
            writer.write(listToCsv(users.getRandomUsers()));
            LOGGER.info("Users written to .csv");
        } catch (IOException e) {
            LOGGER.error("Something went wrong :( ", e);
        }
    }

    public static String listToCsv(List<User> users) {
        StringBuilder result = new StringBuilder();

        // CSV header
        result.append("fullname, location");

        for (User user : users) {
            String line = String.format("\n\"" + user.fullName() + "\"" + ", " + "\"" + user.location() + "\"");
            result.append(line);
        }

        return result.toString();
    }
}
