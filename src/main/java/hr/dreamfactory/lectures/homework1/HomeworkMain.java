package hr.dreamfactory.lectures.homework1;

import com.sun.istack.internal.NotNull;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.lectures.homework1.api.RandomUserAPI;
import hr.dreamfactory.lectures.homework1.api.RecommendationAPI;
import hr.dreamfactory.lectures.homework1.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class HomeworkMain {

    private static String FIELD_ONE = "fullname";
    private static String FIELD_TWO = "location";

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeworkMain.class);

    public static void main(String[] args) {
        RandomUserAPI api =  Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new GsonDecoder())
                .target(RandomUserAPI.class, "https://randomuser.me/");
        UserModels result = api.recommend("10");
        for (UserModel userModel : result.getResults()) {
            System.out.println(userModel);
        }

    }

    public static void writeToCSVFile(@NotNull Path path, @NotNull List<UserMock> users) {
        if (users.size() == 0) {
            return;
        }

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile(), true))) {
            bufferedWriter.write(FIELD_ONE + ", " + FIELD_TWO);
            bufferedWriter.newLine();

            for (UserMock user : users) {
                bufferedWriter.write(user.serializeToCSV());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            LOGGER.error(e.toString());
        }
    }
}
