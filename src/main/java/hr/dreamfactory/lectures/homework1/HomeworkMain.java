package hr.dreamfactory.lectures.homework1;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.lectures.homework1.api.UserAPI;
import hr.dreamfactory.lectures.homework1.common.User;
import hr.dreamfactory.lectures.homework1.model.UsersModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HomeworkMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeworkMain.class);

    public static void main(String[] args) {
        UserAPI api = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new GsonDecoder())
                .target(UserAPI.class, "https://randomuser.me/");

        UsersModel usersModel = api.getUsers("4");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("chicken.csv"))) {
            writer.write(listToCsv(usersModel.getRandomUsers()));
            LOGGER.info("Users written to .csv");
        } catch (IOException e) {
            LOGGER.error("Something went wrong :( ", e);
        }
    }

    public static String listToCsv(List<User> users) {
        StringBuilder result = new StringBuilder();

        result.append("fullname, location");

        for (User user : users) {
            String line = String.format("\n\"" + user.fullName() + "\"" + ", " + "\"" + user.location() + "\"");
            result.append(line);
        }

        return result.toString();
    }
}
