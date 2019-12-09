package hr.dreamfactory.lectures.homework1;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.lectures.homework1.api.RandomUserAPI;
import hr.dreamfactory.lectures.homework1.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class HomeworkMain {
    private static final String FILE_PATH = "./ducks.csv";
    private static final String BASE_URL = "https://randomuser.me/";
    private static final String NUM_OF_USERS = "10";

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeworkMain.class);

    public static void main(String[] args) {
        RandomUserAPI api = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new GsonDecoder())
                .target(RandomUserAPI.class, BASE_URL);

        UserModels result = api.recommend(NUM_OF_USERS);

        Path output = Paths.get(FILE_PATH);
        writeToCSVFile(output, result.getResults());
    }

    public static void writeToCSVFile(Path path, List<UserModel> users) {
        if (users.size() == 0) {
            return;
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile(), true))) {
            if (path.toFile().exists() && path.toFile().length() == 0) {
                bufferedWriter.write("fullname, location");
                bufferedWriter.newLine();
            }

            for (UserModel user : users) {
                bufferedWriter.write(user.serializeToCSV());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            LOGGER.error(e.toString());
        }
    }
}
