package hr.dreamfactory.lectures.homework1.controllers;

import hr.dreamfactory.lectures.homework1.common.UserGenerator;
import hr.dreamfactory.lectures.homework1.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UsersToCSV {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersToCSV.class);

    private String filename;
    private UserGenerator userRepository;

    public UsersToCSV(String filename, UserGenerator userRepository) {
        this.filename = filename;
        this.userRepository = userRepository;
    }

    public void serialize(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(serializeUsers(userRepository.generate()));
            LOGGER.info("Users written to .csv");
        } catch (IOException e) {
            LOGGER.error("Something went wrong :( ", e);
        }
    }

    public static String serializeUsers(List<User> users) {
        StringBuilder result = new StringBuilder();

        result.append("fullname, location");

        for (User user : users) {
            String line = String.format("\n\"" + user.fullName() + "\"" + ", " + "\"" + user.location() + "\"");
            result.append(line);
        }

        return result.toString();
    }
}
